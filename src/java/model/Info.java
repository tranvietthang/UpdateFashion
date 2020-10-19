/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ThangCoi
 */
public class Info {
    private int id;
    private String name;
    private String image;
    private int age;
    private String description;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Info(int id, String name, String image, int age, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.age = age;
        this.description = description;
    }

    public Info() {
    }
    
}
