package com.mysqlsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String home(){
        return "<h1>Welcome home</h1>";
    }

    @GetMapping("/user")
    public String getUser(){
        return "<h1>User Page</h1>";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "<h1>Admin Page</h1>";
    }
}
