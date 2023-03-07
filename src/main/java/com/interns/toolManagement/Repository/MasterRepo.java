package com.interns.toolManagement.Repository;

import com.interns.toolManagement.Entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepo extends JpaRepository<Master, Long> {
}
