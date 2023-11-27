package com.example.pracprj3backend.domain;

import lombok.Data;

@Data
public class Member {
    private Integer id;
    private String userId;
    private String userPassword;
    private String userNickName;
    private String userEmail;
    private String userInserted;

}
