package com.driver.models;

import javax.persistence.*;


@Entity
@Table(name="image")
public class Image{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private String dimension;


    @ManyToOne
    @JoinColumn
    private Image imageVariableName;

    public Image getImageVariableName() {
        return imageVariableName;
    }

    public void setImageVariableName(Image imageVariableName) {
        this.imageVariableName = imageVariableName;
    }

    public Image(){

    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}