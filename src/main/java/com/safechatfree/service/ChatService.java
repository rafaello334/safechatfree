package com.safechatfree.service;

import com.safechatfree.model.Chat;
import com.safechatfree.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {
    private static final Map<String, Chat> chats = new HashMap<>();

    public void sendMessage(String chatName, String username, String message) {
        chats.get(chatName).getMessages().put(System.currentTimeMillis(), new Message(username, message));
    }

    public Chat getChat(String chatName) {
        Chat chat;
        if(chats.containsKey(chatName)) {
            chat = chats.get(chatName);
        } else {
            chat = new Chat(chatName);
            chats.put(chatName, chat);
        }
        return chat;
    }

    public List<Chat> getAllChats() {
        return new ArrayList<>(chats.values());
    }
}
