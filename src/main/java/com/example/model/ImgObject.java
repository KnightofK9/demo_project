package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.File;

/**
 * Created by Knight of k9 on 23/11/2015.
 */
@Entity
@Table(name = "imgObject")
public class ImgObject extends TimeStampObject
{
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ImgObject(String path) {
        super();
        this.path = path;
    }
}
