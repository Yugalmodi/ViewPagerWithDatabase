package com.techpalle.viewpagerwithdatabaseexample;

/**
 * Created by DELL on 10-Jan-17.
 */
public class Student {
    private String id, name, subject, email;

    public Student() {
    }

    public Student(String id, String name, String subject, String email) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
