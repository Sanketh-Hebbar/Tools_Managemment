package com.interns.toolManagement.Service;

import com.interns.toolManagement.Entity.User;
import com.interns.toolManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Object validateUserLogin(String userName, String password ) {


        User foundUser = userRepository.findByNameAndPassword(userName, password);
        // if the user does not exist
        if (foundUser == null) {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
        // If the user exist then display all the tools owned by him
        else
        {

            return userRepository.getUserOwnedTools(foundUser.getId());
        }


    }
}
