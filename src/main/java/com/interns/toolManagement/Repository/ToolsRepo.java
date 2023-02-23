package com.interns.toolManagement.Repository;

import com.interns.toolManagement.Entity.ToolsMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolsRepo extends JpaRepository<ToolsMaster,Long> {
}
