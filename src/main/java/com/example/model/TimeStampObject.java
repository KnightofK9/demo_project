package com.example.model;

import javax.persistence.MappedSuperclass;

/**
 * Created by Knight of k9 on 21/11/2015.
 */
@MappedSuperclass
public class TimeStampObject extends IdObject {
    private long tsCreated;
    private long tsModified;

    public long getTsCreated() {
        return tsCreated;
    }

    public void setTsCreated(long tsCreated) {
        this.tsCreated = tsCreated;
    }


    public long getTsModified() {
        return tsModified;
    }

    public void setTsModified(long tsModified) {
        this.tsModified = tsModified;
    }

    public TimeStampObject() {
        super();
        this.tsCreated = System.currentTimeMillis();
        this.tsModified = this.tsCreated;
    }
}
