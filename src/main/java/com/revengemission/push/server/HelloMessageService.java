package com.revengemission.push.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloMessageService {

    @Value("${netty.port:unknown}")
    private String port;

    public String getPort() {
        return port;
    }
}