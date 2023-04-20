package com.interns.toolManagement.Controller;

import com.interns.toolManagement.Entity.Events;
import com.interns.toolManagement.Service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {
    @Autowired
    private EventsService eventsService;
    @PostMapping("/add")
    public Events addEvents(@RequestBody Events events){
        return eventsService.saveEvents(events);
    }

    @GetMapping("/show")
    public List<Events> showEvents(){
        return eventsService.getEvents();
    }
}
