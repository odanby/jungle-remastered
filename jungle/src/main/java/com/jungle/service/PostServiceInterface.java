package com.jungle.service;

import java.util.List;

import com.jungle.entities.Post;

public interface PostServiceInterface {
    
    // create a post
    Post createPostService(Post post);

    // get all posts
    List<Post> getAllPostsService(int UserId);

    // check length of post
    boolean checkTextLength(Post textToCheck);

    boolean deletePostService(Post postToBeDeleted);

}
