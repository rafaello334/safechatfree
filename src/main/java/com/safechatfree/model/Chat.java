package com.safechatfree.model;

import lombok.Data;

import java.util.Map;
import java.util.TreeMap;

@Data
public class Chat {
    private String chatName;
    private Map<Long, Message> messages = new TreeMap<>();

    public Chat(String chatName) {
        this.chatName = chatName;
    }
}
