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


    public User validateUserLogin(String userName, String password ) {


        User foundUser = userRepository.findByNameAndPassword(userName, password);
        // if the user does not exist
        if (foundUser == null) {


            return null;
        }
        // If the user
        else
        {

            return foundUser;

        }


    }
    public Object findUserTools(Long userId){
        return userRepository.getUserOwnedTools(userId);
    }
}
