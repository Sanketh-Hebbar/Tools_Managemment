package com.interns.toolManagement.Service;

import com.interns.toolManagement.Entity.Notifications;
import com.interns.toolManagement.Entity.Tools;
import com.interns.toolManagement.Entity.User;
import com.interns.toolManagement.Repository.NotificationsRepo;
import com.interns.toolManagement.Repository.ToolsRepo;
import com.interns.toolManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private NotificationsRepo notificationsRepo;

    @Autowired
    private ToolsRepo toolsRepo;


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




    //User requesting the tools from master display and this api will add it to notification table
    public Notifications addRequest(Notifications notifications){
        Notifications notification = new Notifications();
        notification.setStatus(false);
        return notificationsRepo.save(notifications);
    }

//    notification.setNotificationID(notifications.getNotificationID());
//        notification.setMaster(notifications.getMaster());
//        notification.setToolName(notifications.getToolName());
//        notification.setUser(notifications.getUser());
//        notification.setQuantity(notifications.getQuantity());
//        notification.setStatus(false);
//
//        return notification;


    //Showing all the notifications for the toolManager
    public List<Notifications> showNotifications(){

        return notificationsRepo.findByStatus(false);
//        return  notificationsRepo.findAll();
    }

    //tool manager approves or rejects the request
    public Tools approveRequest(Tools tools){
        List<Notifications> notificationsList = notificationsRepo.findByMasterAndUser(tools.getMaster(), tools.getUser());
        for (Notifications notifications : notificationsList) {
            notifications.setStatus(true);
            notificationsRepo.save(notifications);
        }
        int i=0;
        int quantity=tools.getQuantity();
        while(i<quantity){
            tools.setTool_object_Id(0L);
            toolsRepo.save(tools);
            i++;
        }
        return tools;

    }

    public String rejectRequest(Long notificationID){
        notificationsRepo.deleteById(notificationID);
        return "Notification deleted";
    }

}





//            tool.setManufacturer(notifications.getManufacturer());
//            tool.setMax_usage_capacity(notifications.getMax_usage_capacity());
//            tool.setNo_of_times_used(notifications.getNo_of_times_used());
//            tool.setPrice(notifications.getPrice());
//            tool.setUser(notifications.getUser());
//            tool.setMaster(notifications.getMaster());
