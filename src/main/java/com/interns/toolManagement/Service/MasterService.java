package com.interns.toolManagement.Service;

import com.interns.toolManagement.Entity.Master;
import com.interns.toolManagement.Entity.User;
import com.interns.toolManagement.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MasterService {
    @Autowired
    private MasterRepo repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ToolsRepo toolsRepo;
    @Autowired
    private EventsRepo eventsRepo;
    @Autowired
    private NotificationsRepo notificationsRepo;

    public Master saveTools(Master tools){
        return repository.save(tools);

    }

    public List<Master> getTools(){
        return repository.findAll();
    }

    public Master updateTool(Long id,Master tool){
        Master existingTool = repository.findById(id).get();
        existingTool.setToolName(tool.getToolName());
        existingTool.setQuantity(tool.getQuantity());
        return repository.save(existingTool);
    }

    //to update existing master tool quantity
    public void updateExistingToolQuantity(Long toolId,int quantity){
        Optional<Master> masterOptional = repository.findById(toolId);
        if (masterOptional.isPresent()) {
            Master master = masterOptional.get();
            master.setQuantity(quantity);
            repository.save(master);
        } else {
            System.out.println("Master tool with the given ID does not exist");
        }
    }

    public String deleteTool(Long id){
        repository.deleteById(id);
        return "Tool:"+id+" removed";
    }

    //shows users having role toolManager and user
    public List<User> showUsers(){
        return userRepository.findByRoleIn(Arrays.asList("toolManager", "user"));
    }

    //deleting user by user id
    @Transactional
    public void blockUser(Long id){
        Optional<User> userOptional=userRepository.findById(id);
        if(userOptional.isPresent()){
            User user=userOptional.get();
            user.setIsblocked(true);
            userRepository.save(user);
        }else {
            System.out.println("user does not exist");
        }

    }

}
