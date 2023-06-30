package com.aws.dynamodb.controller;

import com.aws.dynamodb.model.UserDetail;
import com.aws.dynamodb.model.UserLogin;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @PostMapping("/register")
    public String createAccount(@RequestBody UserDetail user) {

        if(!user.getPassword().equals(user.getReEnterPassword())) {
            return "Passwords didn't match. Please retry.";
        }

        return "Account created Successfully.";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLogin user) {

        var existingCredentials = UserLogin.builder().email("raju@gamil.com").password("Password").build(); // Get it from Database

        if(!user.getEmail().equals(existingCredentials.getEmail())) {
            return "Username mismatched. Please retry.";
        }
        if(!user.getPassword().equals(existingCredentials.getPassword())) {
            return "Password mismatched. Please retry.";
        }

        return "Logged-in Successfully.";
    }

}
