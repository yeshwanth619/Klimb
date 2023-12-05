package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EntityClass;
import com.example.demo.service.RateService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rates")
public class controller {

    @Autowired
    private RateService rateService;

    @GetMapping("/all")
    public ResponseEntity<List<EntityClass>> getAllLogs(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
                                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {
        try {
           
            List<EntityClass> logs = rateService.getAllLogs(startTime, endTime);
            return ResponseEntity.ok(logs);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Collections.emptyList());
        }
    }
}
