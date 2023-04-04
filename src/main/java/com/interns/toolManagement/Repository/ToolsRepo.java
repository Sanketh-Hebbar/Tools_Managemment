package com.interns.toolManagement.Repository;

import com.interns.toolManagement.Entity.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ToolsRepo extends JpaRepository<Tools,Long> {

    @Query("SELECT t FROM Tools t WHERE t.master.toolId = :toolId")
    public ArrayList<Object> getToolObjectsByToolId(@Param("toolId") Long masterId);

}
