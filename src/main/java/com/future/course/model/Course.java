package com.future.course.model;


import java.io.Serializable;
import java.math.BigInteger;


public class Course implements Serializable {

    private BigInteger courseid;
    private String coursename;
    private String author;

    public Course(){}

    public BigInteger getCourseid() {
        return courseid;
    }

    public void setCourseid(BigInteger courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
