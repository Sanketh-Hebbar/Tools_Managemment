package com.interns.toolManagement.Controller;

import com.interns.toolManagement.Entity.Master;
import com.interns.toolManagement.Service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Tools")
public class MasterController {

    @Autowired
    private MasterService service;

    @PostMapping("/add")
    public Master addTools(@RequestBody Master tools){
        return service.saveTools(tools);
    }

}
