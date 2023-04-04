package com.interns.toolManagement.Controller;

import com.interns.toolManagement.Entity.Master;
import com.interns.toolManagement.Service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

public class MasterController {

    @Autowired
    private MasterService service;

    @PostMapping("/add")
    public Master addTools(@RequestBody Master tools){
        return service.saveTools(tools);
    }

    @GetMapping("/getAllTools")
    public List<Master> fetchTools(){
        return service.getTools();
    }

    @PutMapping("/updateTools/{id}")
    public Master updateTool(@PathVariable Long id, @RequestBody Master tool){
        return service.updateTool(id, tool);
    }

    @DeleteMapping("/removeTool/{id}")
    public String remove(@PathVariable Long id){
        return service.deleteTool(id);
    }


}
