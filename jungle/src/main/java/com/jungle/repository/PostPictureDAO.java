package com.jungle.repository;

import com.jungle.entities.PostPicture;
import com.jungle.utils.HibernateUtil;

public class PostPictureDAO implements PostPictureInterface {

    @Override
    public PostPicture createPicture(PostPicture createPicture) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(createPicture);
        HibernateUtil.persistandcomiit(createPicture);

        return createPicture;
    }

    @Override
    public PostPicture getAllPictures(int postID) {
        HibernateUtil.beginTransaction();
        PostPicture requestList = HibernateUtil.getSession().createQuery("from PostPicture where postId = :post_ID", PostPicture.class).setParameter("post_ID", postID).uniqueResult();
        HibernateUtil.endTransaction();
        return requestList;
    }
    
}
