package com.jungle.service;

import java.util.List;

import com.jungle.entities.Comment;
import com.jungle.exceptions.TooManyCharacters;
import com.jungle.repository.CommentDAO;

public class CommentService implements CommentServiceInterface {

    private final CommentDAO commentDAO;

    public CommentService(CommentDAO commentDAO){
        this.commentDAO = commentDAO;
    }

    @Override
    public boolean checkCommentLength(Comment commentToCheck) {
        if(commentToCheck.getComment_text().length() > 100){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Comment createCommentService(Comment createComment) {
        boolean valCheck1 = checkCommentLength(createComment);

        if(valCheck1){
            return this.commentDAO.createComment(createComment);
        } else {
            throw new TooManyCharacters("Your comment is too long!");
        }
    }

    @Override
    public List<Comment> getCommentsByPost(int post_id) {
        return this.commentDAO.getAllCommentsByPost(post_id);
    }

    @Override
    public List<Comment> getCommentsByUser(int user_id) {
        return this.commentDAO.getAllCommentsByUser(user_id);
    }

    @Override
    public boolean deleteCommentService(Comment commentToBeDeleted) {
        return this.commentDAO.deleteComment(commentToBeDeleted);
    }
    
}
