package com.jungle.service;

import java.util.ArrayList;

import com.jungle.entities.ChatMessage;

public interface ChatServiceInterface {
    
    ChatMessage serviceCreateMessageObject(ChatMessage chatMessage);

    ArrayList<ChatMessage> serviceGetMessageHistory();
    
}
