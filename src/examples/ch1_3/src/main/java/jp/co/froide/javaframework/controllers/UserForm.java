package jp.co.froide.javaframework.controllers;

public class UserForm {
    private String name;

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
