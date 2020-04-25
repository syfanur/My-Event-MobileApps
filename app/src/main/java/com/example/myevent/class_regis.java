package com.example.myevent;

public class class_regis {
    private String Surename;
    private String Name;
    private String Email;
    private String Pass;

    public class_regis(String surename, String name, String email, String pass) {
        Surename = surename;
        Name = name;
        Email = email;
        Pass = pass;
    }

    public String getSurename() {
        return Surename;
    }

    public void setSurename(String surename) {
        Surename = surename;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public class_regis() {
    }
}


