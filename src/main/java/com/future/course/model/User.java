package com.future.course.model;


import java.io.Serializable;
import java.math.BigInteger;

public class User implements Serializable {

    private BigInteger userid;

    private BigInteger courseid;

    private String username;


    public User() {
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public BigInteger getCourseid() {
        return courseid;
    }

    public void setCourseid(BigInteger courseid) {
        this.courseid = courseid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
