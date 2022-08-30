package com.jungle.service;

import java.util.Base64;

import com.jungle.entities.PostPicture;
import com.jungle.repository.PostPictureDAO;

public class PostPictureService implements PostPictureServiceInterface {

    private final PostPictureDAO postPictureDAO;

    public PostPictureService (PostPictureDAO postPictureDAO){
        this.postPictureDAO = postPictureDAO;
    }

    @Override
    public boolean checkImgSize(PostPicture imageToCheck) {
        byte[] encoded = Base64.getMimeEncoder().encode(imageToCheck.getPicture());

        String printStr = "data:image/jpeg;base64, ";
        String encodedStr = new String(encoded);
        String imageStr = printStr+encodedStr;
        if(imageStr.length() > 1E6){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public PostPicture createPictureService(PostPicture createPicture) {
        return postPictureDAO.createPicture(createPicture);
    }

    @Override
    public PostPicture getAllPicturesService(int postID) {
        return postPictureDAO.getAllPictures(postID);
    }
    
}
