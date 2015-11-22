package com.example.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.security.Timestamp;

/**
 * Created by Knight of k9 on 21/11/2015.
 */
@MappedSuperclass
public class IdObject extends AbstractObject {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public IdObject() {
        super();
    }
}
