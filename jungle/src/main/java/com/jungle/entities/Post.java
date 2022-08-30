package com.jungle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post_table") // this class is mapped to user_table in my database
public class Post {

    // these fields represent data in database
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private int postId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "post_text")
    private String postText;
    @Column(name = "image-format")
    private String imageFormat;

    // constructors

        // an empty constructor for Hibernate
        public Post(){}

        // a full constructor to create full objects
        public Post(int postId, int userId, String postText, String imageFormat){
            this.postId = postId;
            this.userId = userId;
            this.postText = postText;
            this.imageFormat = imageFormat;
        }

        // a constructor without a pre-set id
        public Post(int userId, String postText, String imageFormat){
            this.userId = userId;
            this.postText = postText;
            this.imageFormat = imageFormat;
        }

        // a constructor for just text and image
        public Post(String postText, String imageFormat){
            this.postText = postText;
            this.imageFormat = imageFormat;
        }

    // getters and setters
    
        public int getPostId() {
            return postId;
        }


        public void setPostId(int postId) {
            this.postId = postId;
        }


        public int getUserId() {
            return userId;
        }


        public void setUserId(int userId) {
            this.userId = userId;
        }


        public String getPostText() {
            return postText;
        }


        public void setPostText(String postText) {
            this.postText = postText;
        }


        public String getImageFormat() {
            return imageFormat;
        }


        public void setImageFormat(String imageFormat) {
            this.imageFormat = imageFormat;
        }


    // printing everything out as a String
    
        @Override
        public String toString() {
            return "Post [imageFormat=" + imageFormat + ", postId=" + postId + ", postText=" + postText
                    + ", userId=" + userId + "]";
        }
}

