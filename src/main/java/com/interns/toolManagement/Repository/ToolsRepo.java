package com.interns.toolManagement.Repository;

import com.interns.toolManagement.Entity.Master;
import com.interns.toolManagement.Entity.Tools;
import com.interns.toolManagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ToolsRepo extends JpaRepository<Tools,Long> {

    @Query("SELECT t FROM Tools t WHERE t.master.toolId = :toolId")
    public ArrayList<Object> getToolObjectsByToolId(@Param("toolId") Long masterId);

    public void deleteByUserId(Long id);

    public List<Tools> findAllByMasterAndUser(Master master, User user);
}
