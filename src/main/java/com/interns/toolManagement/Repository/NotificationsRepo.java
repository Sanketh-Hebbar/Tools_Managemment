package com.interns.toolManagement.Repository;

import com.interns.toolManagement.Entity.Master;
import com.interns.toolManagement.Entity.Notifications;
import com.interns.toolManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationsRepo extends JpaRepository<Notifications,Long> {
    public List<Notifications> findByStatus(boolean status);
    public List<Notifications> findByMasterAndUser(Master master, User user);
}
