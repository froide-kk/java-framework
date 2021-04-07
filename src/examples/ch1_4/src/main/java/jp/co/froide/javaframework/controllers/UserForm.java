package jp.co.froide.javaframework.controllers;

import java.io.Serializable;

public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    public UserForm() {
        this.name = "";
    }

    public UserForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
