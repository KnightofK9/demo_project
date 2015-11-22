package com.example.model;

import org.omg.CORBA.TIMEOUT;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created by Knight of k9 on 21/11/2015.
 */
@Entity
@Table(name = "post")
public class Post extends TimeStampObject {

    private String title;
    private String content;
    private String ownerName;
    private String categoryName;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Post(String title, String content, String ownerName, String categoryName) {
        super();
        this.title = title;
        this.content = content;
        this.ownerName = ownerName;
        this.categoryName = categoryName;
    }
    public Post(){super();}

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
