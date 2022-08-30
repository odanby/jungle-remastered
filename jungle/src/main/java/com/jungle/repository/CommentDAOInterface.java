package com.jungle.repository;

import java.util.List;

import com.jungle.entities.Comment;

public interface CommentDAOInterface {
    
    // create comment
    Comment createComment(Comment createComment);
 
    // get all comments by a post
    List<Comment> getAllCommentsByPost(int post_id);
 
    // get all comments by a user
    List<Comment> getAllCommentsByUser(int user_id);

    // delete comment
    boolean deleteComment(Comment commentToBeDeleted);

}
