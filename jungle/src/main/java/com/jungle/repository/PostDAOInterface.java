package com.jungle.repository;

import java.util.List;

import com.jungle.entities.Post;


public interface PostDAOInterface {
    
    // create posts
    Post createPost(Post createPost); 

    // get posts
    List<Post> getAllPosts(int UserId);

    // delete posts
    boolean deletePost(Post postToBeDeleted);
}
