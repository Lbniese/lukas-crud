package com.example.lukascrud.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Assignment {

    @Id
    private int id;
    private String name;
    private String description;

    public Assignment() {

    }

    public Assignment(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
