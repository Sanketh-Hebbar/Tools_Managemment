package com.interns.toolManagement.Service;

import com.interns.toolManagement.Entity.Master;
import com.interns.toolManagement.Repository.MasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterService {
    @Autowired
    private MasterRepo repository;

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

    public String deleteTool(Long id){
        repository.deleteById(id);
        return "Tool:"+id+" removed";
    }




}
