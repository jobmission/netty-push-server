package com.revengemission.netty.push.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloMessageService {

    @Value("${netty.port:unknown}")
    private String name;

    public String getName() {
        return name;
    }
}