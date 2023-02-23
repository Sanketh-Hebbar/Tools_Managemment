package com.interns.toolManagement.Service;

import com.interns.toolManagement.Entity.ToolsMaster;
import com.interns.toolManagement.Repository.ToolsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolsService {
    @Autowired
    private ToolsRepo repository;

    public ToolsMaster saveTools(ToolsMaster tools){
        return repository.save(tools);

    }

}
