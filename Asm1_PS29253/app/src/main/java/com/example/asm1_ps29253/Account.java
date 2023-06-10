package com.example.asm1_ps29253;

import java.util.ArrayList;

public class Account {
    private String user,pass;
    private Boolean Remember;

    public Account(String user, String pass, Boolean remember) {
        this.user = user;
        this.pass = pass;
        Remember = remember;
    }

    public Account() {
    }

    public Account(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getRemember() {
        return Remember;
    }

    public void setRemember(Boolean remember) {
        Remember = remember;
    }
}
