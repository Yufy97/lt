package com.zt.handler;

import com.zt.entity.po.ConnectPacket;
import com.zt.entity.po.User;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import com.zt.util.ChannelUtils;

public class ConnectHandler extends SimpleChannelInboundHandler<ConnectPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ConnectPacket connectPacket) throws Exception {
        User user = connectPacket.getUser();

        ChannelUtils.bind(user, ctx.channel());
    }
}
