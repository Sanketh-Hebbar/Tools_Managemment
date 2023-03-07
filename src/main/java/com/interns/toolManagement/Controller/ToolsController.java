package com.interns.toolManagement.Controller;

import com.interns.toolManagement.Entity.Tools;
import com.interns.toolManagement.Service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ToolObjects")
public class ToolsController {
    @Autowired
    private ToolsService toolsService;
    @PostMapping("/add")
    public Tools addToolObjects(@RequestBody Tools tools){
        return toolsService.saveToolObjects(tools);
    }
}
