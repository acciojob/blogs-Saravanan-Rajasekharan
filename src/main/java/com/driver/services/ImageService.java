package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions)throws Exception{
        //add an image to the blog
        Blog blog=blogRepository2.findById(blogId).get();

        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);

        blog.getImageList().add(image);

        blogRepository2.save(blog);


        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        // from id get the image dimensions

        Image image = imageRepository2.findById(id).get();

        if (image==null) return 0;

        String s = image.getDimensions();
        String [] parts = s.split("X");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);


        String [] part = screenDimensions.split("X");
        int u = Integer.parseInt(part[0]);
        int v = Integer.parseInt(part[1]);

        int count = (u/x)*(v/y);

        return count;
    }
}
