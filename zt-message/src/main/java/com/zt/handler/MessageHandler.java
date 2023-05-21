package com.zt.handler;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zt.entity.po.Message;
import com.zt.entity.po.MessageList;
import com.zt.entity.po.MessagePacket;
import com.zt.entity.po.UnreadMessage;
import com.zt.entity.vo.MessageVo;
import com.zt.service.MessageListService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zt.service.MessageService;
import com.zt.service.UnreadMessageService;
import com.zt.util.ChannelUtils;

import java.time.LocalDateTime;

@ChannelHandler.Sharable
@Component
public class MessageHandler extends SimpleChannelInboundHandler<MessagePacket> {
    @Autowired
    UnreadMessageService unreadMessageService;
    @Autowired
    MessageService messageService;
    @Autowired
    MessageListService messageListService;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessagePacket messagePacket) throws Exception {
        Long toUserId = messagePacket.getToUserId();
        Channel toUserChannel = ChannelUtils.getChannelByUserId(toUserId);

        if(toUserChannel != null) {
            ByteBuf buffer = ctx.alloc().buffer();
            MessageVo messageVo = new MessageVo(messagePacket.getBody(), LocalDateTime.now());
            buffer.writeBytes(JSON.toJSONBytes(messageVo));
            toUserChannel.writeAndFlush(buffer);

            Message message = new Message(messagePacket.getFromUserId(),
                    messagePacket.getToUserId(),
                    messagePacket.getBody(),
                    LocalDateTime.now());
            messageService.save(message);
        } else {
            UnreadMessage unreadMessage = new UnreadMessage(messagePacket.getFromUserId(),
                    messagePacket.getToUserId(),
                    messagePacket.getBody(),
                    LocalDateTime.now());
            unreadMessageService.save(unreadMessage);
        }

        MessageList messageList = new MessageList(null, messagePacket.getFromUserId(), messagePacket.getToUserId(), messagePacket.getBody(), LocalDateTime.now());
        LambdaQueryWrapper<MessageList> lqw = new LambdaQueryWrapper<>();
        lqw.eq(MessageList::getUserId, messagePacket.getFromUserId())
                .eq(MessageList::getToUserId, messagePacket.getToUserId());
        messageListService.saveOrUpdate(messageList, lqw);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ChannelUtils.unbind(ctx.channel());
        ctx.close();
    }
}
