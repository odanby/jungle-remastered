package com.jungle.repository;

import java.util.ArrayList;

import com.jungle.entities.ChatMessage;

public interface ChatDAOInterface {
    
    ChatMessage createMessage(ChatMessage chatMessage);

    ArrayList<ChatMessage> getMessageHistory();
}
