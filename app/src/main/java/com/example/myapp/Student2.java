package com.example.myapp;

public class Student2 {
    String name,course,email;
    int age;
    double percentage;

    public Student2() {
    }



    public Student2(String name, String course, String email, int age, double percentage) {
        this.name = name;
        this.course = course;
        this.email = email;
        this.age = age;
        this.percentage = percentage;
    }

    public Student2(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
