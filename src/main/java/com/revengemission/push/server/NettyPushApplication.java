package com.revengemission.push.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyPushApplication implements CommandLineRunner {

    @Autowired
    private HelloMessageService helloService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(NettyPushApplication.class, args);
    }

    //access command line arguments
    @Override
    public void run(String... args) throws Exception {
        //do something
        System.out.println("=========" + helloService.getPort());
    }
}
