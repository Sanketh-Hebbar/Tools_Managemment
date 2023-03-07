package com.interns.toolManagement.Service;

import com.interns.toolManagement.Entity.Events;
import com.interns.toolManagement.Entity.Master;
import com.interns.toolManagement.Repository.EventsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsService {
    @Autowired
    private EventsRepo eventsRepo;

    public Events saveEvents(Events events){
        return eventsRepo.save(events);
    }

}
