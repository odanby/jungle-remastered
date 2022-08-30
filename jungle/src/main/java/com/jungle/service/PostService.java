package com.jungle.service;

import java.util.List;

import com.jungle.entities.Post;
import com.jungle.exceptions.TooManyCharacters;
import com.jungle.repository.PostDAO;

public class PostService implements PostServiceInterface {

    private final PostDAO postDAO;

    public PostService (PostDAO postDAO) {
        this.postDAO = postDAO;
    }
    
    @Override
    public Post createPostService(Post post) {
        boolean valCheck1 = checkTextLength(post);

        if(valCheck1){
            return this.postDAO.createPost(post);
        } else {
            throw new TooManyCharacters("Your post is too long!");
        }
    }

    @Override
    public List<Post> getAllPostsService(int UserId) {
        return this.postDAO.getAllPosts(UserId);
    }

    @Override
    public boolean checkTextLength(Post textToCheck) {
        if(textToCheck.getPostText().length() > 255){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean deletePostService(Post postToBeDeleted) {
        return this.postDAO.deletePost(postToBeDeleted);
    }
}
