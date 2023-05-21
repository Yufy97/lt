package com.zt.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import com.zt.util.ChannelUtils;

public class HeartBeatHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        ChannelUtils.unbind(ctx.channel());
        ctx.channel().close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ChannelUtils.unbind(ctx.channel());
        super.channelInactive(ctx);
    }
}
