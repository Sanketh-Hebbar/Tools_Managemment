package com.interns.toolManagement.Repository;

import com.interns.toolManagement.Entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationsRepo extends JpaRepository<Notifications,Long> {
    public List<Notifications> findByStatus(boolean status);
}
