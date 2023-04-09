package com.interns.toolManagement.Repository;

import com.interns.toolManagement.Entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MasterRepo extends JpaRepository<Master, Long> {
    @Query("SELECT m.quantity FROM Master m WHERE m.toolId = :toolId")
    int findQuantityByToolId(@Param("toolId") Long toolId);
}
