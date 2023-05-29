package com.zt.server;

import com.zt.handler.ConnectHandler;
import com.zt.handler.HeartBeatHandler;
import com.zt.handler.HttpRequestHandler;
import com.zt.handler.MessageHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.concurrent.TimeUnit;

@RefreshScope
public class MessageServer implements InitializingBean {
    @Value("${netty.port}")
    private int port;

    @Override
    public void afterPropertiesSet() throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        MessageHandler messageHandler = new MessageHandler();
        ConnectHandler connectHandler = new ConnectHandler();
        HeartBeatHandler heartBeatHandler = new HeartBeatHandler();
        HttpRequestHandler httpRequestHandler = new HttpRequestHandler();

        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup, workerGroup);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();

                    pipeline.addLast(new IdleStateHandler(10, 10, 10, TimeUnit.MINUTES));
                    pipeline.addLast(new HttpServerCodec());
                    pipeline.addLast(new ChunkedWriteHandler());
                    pipeline.addLast(new HttpObjectAggregator(1024 * 8));
                    pipeline.addLast(new WebSocketServerProtocolHandler("/message"));
                    pipeline.addLast(httpRequestHandler);
                    pipeline.addLast(connectHandler);
                    pipeline.addLast(messageHandler);
                    pipeline.addLast(heartBeatHandler);
                }
            });


            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
