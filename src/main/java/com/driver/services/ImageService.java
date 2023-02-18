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

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image = new Image();
        image.setDescription(description);
        image.setDimension(dimensions);
        imageRepository2.save(image); //Save image

        // add image to imageList
        Blog blog = blogRepository2.findById(blogId).get();
        List<Image> imageList = blog.getImages();
        imageList.add(image);

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
        String s = image.getDimension();
        String [] parts = s.split("X");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);

        int prod = x*y;

        String [] part = screenDimensions.split("X");
        int u = Integer.parseInt(part[0]);
        int v = Integer.parseInt(part[1]);

        int div = u*v;

        return prod/div;
    }
}
