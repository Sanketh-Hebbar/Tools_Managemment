package com.interns.toolManagement.Repository;

import com.interns.toolManagement.Entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepo extends JpaRepository<Notifications,Long> {
}
