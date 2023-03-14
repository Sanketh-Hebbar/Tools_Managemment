package com.interns.toolManagement.Controller;

import com.interns.toolManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService  userService;

    @PostMapping("/login")
    public Object validateLogin(@RequestBody HashMap<String,Object> userDetails )
    {
        String userName=userDetails.get("userName").toString();
        String password=userDetails.get("password").toString();

        return userService.validateUserLogin(userName,password);



    }
//

}
