package com.demo1;

public class Student {
    private int id;
    private String fullName, course;
    private double score;
//    public Student(int id, String fullName, String course, double score) {
//        this.id = id;
//        this.fullName = fullName;
//        this.course = course;
//        this.score = score;
//    }
    public void setId(int id) {
        this.id = id;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public int getId() {
        return id;
    }
    public String getCourse() {
        return course;
    }
    public String getFullName() {
        return fullName;
    }
    public double getScore() {
        return score;
    }
}
