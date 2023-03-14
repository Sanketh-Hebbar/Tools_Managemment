package com.interns.toolManagement.Repository;

import com.interns.toolManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
//    @Query("select u from User u where u.email= :email")
//    public User getUserByUserMail(@Param("email") String email);                     //implemented body is in service as its interface.
//                                                                                    //Query provides user body as a return type when string email is passed.



}
