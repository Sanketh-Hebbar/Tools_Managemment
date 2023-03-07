package com.interns.toolManagement.Repository;

import com.interns.toolManagement.Entity.Tools;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolsRepo extends JpaRepository<Tools,Long> {
}
