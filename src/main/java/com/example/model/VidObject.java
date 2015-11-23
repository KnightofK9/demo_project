package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Knight of k9 on 23/11/2015.
 */
@Entity
@Table(name = "vidObject")
public class VidObject extends TimeStampObject
{
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public VidObject(String path) {
        super();

        this.path = path;
    }
    public VidObject(){};
}
