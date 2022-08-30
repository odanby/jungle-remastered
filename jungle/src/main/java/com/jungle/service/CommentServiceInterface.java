package com.jungle.service;

import java.util.List;

import com.jungle.entities.Comment;

public interface CommentServiceInterface {
    
    // check to see if text is too long
    boolean checkCommentLength(Comment commentToCheck);

    // create method
    Comment createCommentService(Comment createComment);

    // get comments by post id
    List<Comment> getCommentsByPost(int post_id);
    
    // get comments by user id
    List<Comment> getCommentsByUser(int user_id);

    // delete comment
    boolean deleteCommentService(Comment commentToBeDeleted);

    
}
