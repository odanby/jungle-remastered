package com.jungle.repository;

import java.util.List;

import com.jungle.entities.Post;
import com.jungle.utils.HibernateUtil;

public class PostDAO implements PostDAOInterface {

    @Override
    public Post createPost(Post createPost) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(createPost);
        HibernateUtil.endTransaction();
        return createPost;
    }

    @Override
    public List<Post> getAllPosts(int UserId) {
        HibernateUtil.beginTransaction();
        List<Post> requestList = HibernateUtil.getSession().createQuery("from Post where userId = :UserID", Post.class).setParameter("UserID", UserId).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public boolean deletePost(Post postToBeDeleted) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(postToBeDeleted);
        HibernateUtil.endTransaction();
        return true;
    }
    
}
