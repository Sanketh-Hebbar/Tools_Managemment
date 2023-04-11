package com.interns.toolManagement.Repository;

import com.interns.toolManagement.Entity.Notifications;
import com.interns.toolManagement.Entity.Tools;
import com.interns.toolManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;


public interface UserRepository extends JpaRepository<User,Long> {


    public User findByEmailAndPassword(String email, String password);

    @Query("SELECT t FROM Tools t JOIN t.master m WHERE t.user.id = :id")
    public ArrayList<Object> getUserOwnedTools(@Param("id") Long userId);


    public List<User> findByRoleIn(List<String> asList);
}
