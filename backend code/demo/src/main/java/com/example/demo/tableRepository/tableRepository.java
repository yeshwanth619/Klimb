
package com.example.demo.tableRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.EntityClass;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface tableRepository extends JpaRepository<EntityClass, Long> {

  
	
     List<EntityClass> findByTimestampBetween(LocalDateTime startDate, LocalDateTime endDate);

    
}