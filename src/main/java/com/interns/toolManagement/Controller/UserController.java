package com.interns.toolManagement.Controller;

import com.interns.toolManagement.Entity.Master;
import com.interns.toolManagement.Entity.Notifications;
import com.interns.toolManagement.Entity.Tools;
import com.interns.toolManagement.Entity.User;
import com.interns.toolManagement.Service.EventsService;
import com.interns.toolManagement.Service.MasterService;
import com.interns.toolManagement.Service.ToolsService;
import com.interns.toolManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ToolsService toolsService;
    @Autowired
    private MasterService masterService;
    @Autowired
    private EventsService eventsService;

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }


    @PostMapping("/login")
    public Object validateLogin(@RequestBody HashMap<String, Object> userDetails) {
        String userName = userDetails.get("userName").toString();
        String password = userDetails.get("password").toString();

        User foundUser = userService.validateUserLogin(userName, password);

        if (foundUser == null) {
            return new ResponseEntity<>("Unauthorized access", HttpStatus.UNAUTHORIZED);
        } else {

            HashMap<String,String> userRole=new HashMap<>();
            userRole.put("userRole",foundUser.getRole());
            userRole.put("userId",foundUser.getId().toString());
            userRole.put("userName",foundUser.getName());
            // if the client is the user
            if (foundUser.getRole().equals("user")) {


                ArrayList<Object> userTools= (ArrayList<Object>) userService.findUserTools(foundUser.getId());
                userTools.add(userRole);
                return userTools;

            }
            // If the role of the client is admin return the master table
            else if (foundUser.getRole().equals("admin")) {
                ArrayList<Object> masterTools=new ArrayList<>(masterService.getTools());
                masterTools.add(userRole);
                return  masterTools;
            }
            // if the role of the client is tool Manager return the tools table
            ArrayList<Object> toolsTable=new ArrayList<>(toolsService.getToolObjects());
            toolsTable.add(userRole);

            return toolsTable;
        }

    }

    @PostMapping("/addNotification")
    public Notifications addNotification(@RequestBody Notifications notifications){
        return userService.addRequest(notifications);
    }

    //Showing all the notifications for the toolManager
    @GetMapping("/showNotifications")
    public List<Notifications> showNotifications(){
        return userService.showNotifications();
    }

    //When toolManager approves the user request
    @PostMapping("/approveRequest")
    public Tools approveRequest(@RequestBody Tools tools){
        return userService.approveRequest(tools);
    }

    //When toolManager rejects the user request
    @DeleteMapping("/deleteNotification/{notificationId}")
    public String rejectRequest(@PathVariable Long notificationId){
        return userService.rejectRequest(notificationId);
    }

}
