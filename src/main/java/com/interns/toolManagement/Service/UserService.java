package com.interns.toolManagement.Service;

import com.interns.toolManagement.Entity.Master;
import com.interns.toolManagement.Entity.Notifications;
import com.interns.toolManagement.Entity.Tools;
import com.interns.toolManagement.Entity.User;
import com.interns.toolManagement.Repository.MasterRepo;
import com.interns.toolManagement.Repository.NotificationsRepo;
import com.interns.toolManagement.Repository.ToolsRepo;
import com.interns.toolManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private NotificationsRepo notificationsRepo;

    @Autowired
    private ToolsRepo toolsRepo;

    @Autowired
    private MasterRepo masterRepo;

    public User registerUser(User user){
        user.setIsblocked(false);
        return userRepository.save(user);
    }


    public User validateUserLogin(String email, String password ) {


        User foundUser = userRepository.findByEmailAndPassword( email , password);
        // if the user does not exist
        if (foundUser == null) {


            return null;
        }
        // If the user
        else if(foundUser.isIsblocked()){
            return null;
        }
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

        //gets the master id to update
        Long masterId=tools.getMaster().getToolId();

        int masterQuantity= masterRepo.findQuantityByToolId(masterId);
        int remainingQuantity=masterQuantity-quantity;

        if(remainingQuantity>0) {
            updateMasterQuantity(masterId, remainingQuantity);
        }else {
            System.out.println("Remaining quantity is less than 0");
        }


        return tools;

    }

    public void updateMasterQuantity(Long masterId, int remainingQuantity) {
        Optional<Master> masterOptional = masterRepo.findById(masterId);
        if (masterOptional.isPresent()) {
            Master master = masterOptional.get();
            master.setQuantity(remainingQuantity);
            masterRepo.save(master);
        } else {
            System.out.println("Master tool with the given ID does not exist");
        }
    }

    public String rejectRequest(Long notificationID){
        notificationsRepo.deleteById(notificationID);
        return "Notification deleted";
    }

}




