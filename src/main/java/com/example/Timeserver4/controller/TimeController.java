package com.example.Timeserver4.controller;


import com.example.Timeserver4.model.TimeResponse;
import com.example.Timeserver4.service.TimeService;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/v1")
public class TimeController {
    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/time")
    public String getTime(){
        return timeService.getTime();
    }

    @GetMapping("/now")
    public String getNow(){
        return timeService.getNow();
    }

    @GetMapping("/epochTime")
    public Long getEpochTime(){
        return timeService.getEpochTime();
    }

    @GetMapping("/UTCTime")
    public LocalDateTime getUTCTime(@RequestHeader(value = "use") String zone){
        try {
            return timeService.getUTCTime(zone);
        } catch (DateTimeException exc) {
            System.out.println("not a zone");
            throw exc;
        }

    }

    @GetMapping("/getTime")
    public TimeResponse getTimeResponse(){
        return timeService.getTimeResponse();
    }
}
