package com.jungle.service;

import com.jungle.entities.PostPicture;

public interface PostPictureServiceInterface {
    
    // check to see image is too big
    boolean checkImgSize(PostPicture imageToCheck);

    // create method
    PostPicture createPictureService(PostPicture createPicture);
    
    // get all pictures method
    PostPicture getAllPicturesService(int postID);
        
}
