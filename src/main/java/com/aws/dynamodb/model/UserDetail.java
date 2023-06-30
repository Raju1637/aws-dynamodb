package com.aws.dynamodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

    private String name;
    private String email;
    private String password;
    private String reEnterPassword;
    private Long mobile;

    private List<UserAddress> address;
}
