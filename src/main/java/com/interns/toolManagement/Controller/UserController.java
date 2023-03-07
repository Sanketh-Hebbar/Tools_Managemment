package com.interns.toolManagement.Controller;

import com.interns.toolManagement.Entity.User;
import com.interns.toolManagement.Service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserDetailsServiceImpl userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/register")
    public User registerUsers(@RequestBody User user){
        return userService.addUser(user);

    }

    @PostMapping("/sign")
    public String login(String username){
        userService.loadUserByUsername(username);
        return "Success";

    }
 //<----for testing routing using auth--->
    @GetMapping("/dummy")
    public ResponseEntity<String> normalUser(){
        return ResponseEntity.ok("You won");
    }
}
