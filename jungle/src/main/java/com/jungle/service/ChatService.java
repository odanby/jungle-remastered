package com.jungle.service;

import java.util.ArrayList;

import com.jungle.entities.ChatMessage;
import com.jungle.exceptions.InvalidInputException;
import com.jungle.repository.ChatDAO;

public class ChatService implements ChatServiceInterface {

    private final ChatDAO chatDAO;

    public ChatService(ChatDAO chatDAO) {
        this.chatDAO = chatDAO;
    }


    @Override
    public ChatMessage serviceCreateMessageObject(ChatMessage chatMessage) {
        if(chatMessage.getUserId() <= 0){
            throw new InvalidInputException("Invalid User ID");
        } else if (chatMessage.getChatContent().isEmpty()) {
            throw new InvalidInputException("Invalid Chat Content");
        } else if (chatMessage.getChatContent().length() > 300){
            throw new InvalidInputException("Long Content");
        } else {
            return chatDAO.createMessage(chatMessage);
        }
    }

    @Override
    public ArrayList<ChatMessage> serviceGetMessageHistory() {
        return chatDAO.getMessageHistory();
    }
    
}
