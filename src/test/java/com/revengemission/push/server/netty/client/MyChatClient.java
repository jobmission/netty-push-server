package com.revengemission.push.server.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyChatClient {

    public static void main(String[] args) throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                .handler(new MyChatClientInitializer());

            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();

            //标准输入
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            //利用死循环，不断读取客户端在控制台上的输入内容
            for (; ; ) {
                String inputMessage = bufferedReader.readLine();
                if ("".equals(inputMessage) || "".equals(inputMessage.trim())) {
                } else if ("quit".equalsIgnoreCase(inputMessage)) {
                    channel.close();
                    System.exit(1);
                } else {
                    channel.writeAndFlush(inputMessage + "\r\n");
                }
            }

        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
