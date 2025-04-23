package com.learn.config;

import com.learn.handler.ChatWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // SockJS 지원되는 엔드포인트 등록
        registry.addEndpoint("/ws-chat").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 클라이언트 수신 브로커 주소: /topic
        registry.enableSimpleBroker("/topic");
        // 클라이언트 송신 주소 prefix: /app
        registry.setApplicationDestinationPrefixes("/app");
    }
}

