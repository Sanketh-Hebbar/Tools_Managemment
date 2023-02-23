package com.interns.toolManagement.Controller;

import com.interns.toolManagement.Entity.ToolsMaster;
import com.interns.toolManagement.Service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Tools")
public class ToolsController {

    @Autowired
    private ToolsService service;

    @PostMapping("/add")
    public ToolsMaster addTools(@RequestBody ToolsMaster tools){
        return service.saveTools(tools);
    }

}
