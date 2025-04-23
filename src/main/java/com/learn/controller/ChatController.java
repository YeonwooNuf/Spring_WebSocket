package com.learn.controller;

import com.learn.vo.ChatMessageVO;
import com.learn.vo.ChatResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    public void handleMessage(ChatMessageVO chatMessageVO) {
        simpMessagingTemplate.convertAndSend("/topic/public",
                new ChatResponseVO(chatMessageVO.getSender(), chatMessageVO.getContent()));
    }
}
