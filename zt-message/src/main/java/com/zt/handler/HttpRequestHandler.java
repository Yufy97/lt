package com.zt.handler;

import com.alibaba.fastjson.JSON;
import com.zt.entity.po.Packet;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

@ChannelHandler.Sharable
public class HttpRequestHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame textWebSocketFrame) throws Exception {
        String json = textWebSocketFrame.text();
        Packet packet = JSON.parseObject(json, Packet.class);

        ctx.fireChannelRead(packet);
    }
}
