package com.interns.toolManagement.Repository;

import com.interns.toolManagement.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepo extends JpaRepository<Events,Long> {
}
