package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.EntityClass;
import com.example.demo.tableRepository.tableRepository;
@Service
public class RateService {
    private final tableRepository tableRespository;

    public RateService(tableRepository tableRespository) {
        this.tableRespository = tableRespository;
    }

    public List<EntityClass> getAllLogs(LocalDateTime startTime, LocalDateTime endTime) {
        // Retrieve all logs within the specified time range from the repository
        List<EntityClass> logs = tableRespository.findByTimestampBetween(startTime, endTime);
        return logs;
    }
}
