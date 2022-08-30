package com.jungle.entities;

import java.util.Objects;

public class ChatMessage {
    
    private int chatId;
    private String chatDate;
    private int userId;
    private String userName;
    private String chatContent;

    // constructors
        
        public ChatMessage() {

        }

        public ChatMessage(int userId, String chatContent) {
            this.setUserId(userId);
            this.setChatContent(chatContent);
        }

        public ChatMessage(int chatId, String chatDate, int userId, String userName, String chatContent) {
            this.setChatId(chatId);
            this.setChatDate(chatDate);
            this.setUserId(userId);
            this.setUserName(userName);
            this.setChatContent(chatContent);
        }

        // getters and setters
        public int getChatId() {
            return chatId;
        }

        public void setChatId(int chatId) {
            this.chatId = chatId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getChatDate() {
            return chatDate;
        }

        public void setChatDate(String chatDate) {
            this.chatDate = chatDate;
        }

        public String getChatContent() {
            return chatContent;
        }

        public void setChatContent(String chatContent) {
            this.chatContent = chatContent;
        }

        @Override
        public String toString() {
            return "ChatMessage{" +
                    "chatId=" + chatId +
                    ", chatDate='" + chatDate + '\'' +
                    ", userId=" + userId +
                    ", userName='" + userName + '\'' +
                    ", chatContent='" + chatContent + '\'' +
                    '}';
        }

    // to string

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ChatMessage that = (ChatMessage) o;
            return chatId == that.chatId && userId == that.userId && Objects.equals(chatDate, that.chatDate) && Objects.equals(userName, that.userName) && Objects.equals(chatContent, that.chatContent);
        }

        @Override
        public int hashCode() {
            return Objects.hash(chatId, chatDate, userId, userName, chatContent);
        }
}
