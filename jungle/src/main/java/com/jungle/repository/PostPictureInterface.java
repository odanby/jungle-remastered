package com.jungle.repository;

import com.jungle.entities.PostPicture;

public interface PostPictureInterface {
    
    // create method
    PostPicture createPicture(PostPicture createPicture);

    // get method
    PostPicture getAllPictures(int postID);
}
