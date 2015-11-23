package com.example.model;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 * Created by Knight of k9 on 23/11/2015.
 */
@Entity
@Table(name = "fileObject")
public class FileObject extends TimeStampObject
{
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileObject(String path) {
        super();
        this.path = path;
    }
    public FileObject(){}
}
