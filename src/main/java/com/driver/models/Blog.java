package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="blog")
public class Blog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;

    private List<Image> images;

    @ManyToOne
    @JoinColumn
    private User userVariableName;

    @OneToMany(mappedBy = "imageVariableName",cascade = CascadeType.ALL)
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public User getUserVariableName() {
        return userVariableName;
    }

    public void setUserVariableName(User userVariableName) {
        this.userVariableName = userVariableName;
    }

    public Blog() {
        images = new ArrayList<>();
    }

    public Blog(int id, String title, String content, List<Image> images) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}