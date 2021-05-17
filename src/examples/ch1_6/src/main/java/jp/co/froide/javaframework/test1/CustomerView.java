package jp.co.froide.javaframework.test1;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerView implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String birthday;
    private String postaddress;
    private String address;
    private String number;
}

