package com.example.model;



import javax.persistence.*;

/**
 * Created by fuck on 11/5/2015.
 */
@Entity
@Table(name ="user")
public class User extends TimeStampObject{

    private String name;
    private String info;
    private String passworld;
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, String info, String passworld, String email) {
        super();
        this.name = name;
        this.info = info;
        this.passworld = passworld;
        this.email = email;
    }
    public User(){super();};

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", passworld='" + passworld + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
