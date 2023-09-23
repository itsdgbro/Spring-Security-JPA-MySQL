package com.mysqlsecurity.controller;

import com.mysqlsecurity.model.User;
import com.mysqlsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(){
        return "<h1>Welcome home</h1>";
    }

    @GetMapping("/user")
    public String getUser(Principal principal){
        return "<h1>User Page " + principal.getName() + "</h1>";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "<h1>Admin Page</h1>";
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) throws Exception {
        try {
            String username = credentials.get("Username");
            String password = credentials.get("Password");

            //  Load user details using UserDetailsService
            UserDetails userDetails = userService.loadUserByUsername(username);

            // generate token
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password);

            // authenticate
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            System.out.println(authentication);
            // Set authentication in SecurityContext
            return ResponseEntity.ok("Success");
        }catch (UsernameNotFoundException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
