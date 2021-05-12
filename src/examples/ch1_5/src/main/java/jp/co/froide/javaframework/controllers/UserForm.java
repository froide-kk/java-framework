package jp.co.froide.javaframework.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserForm implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
}
