package com.aws.dynamodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {

    private String locality;
    private String city;
    private String state;
    private Long zipcode;

}
