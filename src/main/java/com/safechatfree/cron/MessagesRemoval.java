package com.safechatfree.cron;

import com.safechatfree.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessagesRemoval {
    private final ChatService chatService;

    @Scheduled(fixedRate = 60 * 1000)
    public void messagesRemoval() {
        chatService.getAllChats().forEach(chat -> chat.getMessages().keySet().removeIf(entry -> System.currentTimeMillis() - entry > 2 * 60 * 60 * 1000));
    }
}