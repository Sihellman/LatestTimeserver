package com.example.Timeserver4.service;


import com.example.Timeserver4.model.TimeResponse;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@Service
public class TimeService {
    public String getTime(){
        Date date = new Date();
        return date.toString();
    }
    public String getNow(){
        return  LocalDate.now().toString();
    }

    public Long getEpochTime(){
        Date date = new Date();
        return date.getTime();
    }
    public LocalDateTime getUTCTime(String zone){
        return  LocalDateTime.ofInstant(Instant.now(), ZoneId.of(zone));
    }

    private String getUtcDateFromLocalDate(Date date){
        TimeZone zone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat();
        dateFormat.setTimeZone(zone);
        return dateFormat.format(date);

    }

    public TimeResponse getTimeResponse(){
        Date date = new Date();

        return TimeResponse.builder()
                .localTime(LocalDate.now().toString())
                .build();
               /* .localTime(date.toString())
                .epochMillis(date.getTime())
                .utcTime(getUtcDateFromLocalDate(date))
                .build();*/
    }
}
