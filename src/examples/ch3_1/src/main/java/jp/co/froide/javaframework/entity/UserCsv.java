package jp.co.froide.javaframework.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"ユーザーID", "名前", "パスワード"})
@Getter
@Setter
public class UserCsv implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("ユーザーID")
    Integer id;

    @JsonProperty("名前")
    String name;

    @JsonProperty("パスワード")
    String password;

    public UserCsv(){}

    public UserCsv( Integer id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

}
