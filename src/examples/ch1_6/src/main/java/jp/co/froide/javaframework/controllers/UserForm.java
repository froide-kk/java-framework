package jp.co.froide.javaframework.controllers;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
}
