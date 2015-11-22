package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Knight of k9 on 21/11/2015.
 */
@Entity
@Table(name = "category")
public class Category extends TimeStampObject
{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Category(String name, String info) {
        super();
        this.name = name;
        this.info = info;
    }
    public Category(){super();}

    private String info;

}
