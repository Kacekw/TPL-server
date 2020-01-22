package com.vestas.kawit.logger.controller;

import com.vestas.kawit.logger.service.Log;
import com.vestas.kawit.logger.service.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    private Logging logging;

    @Autowired
    public LogController(Logging logging) {
        this.logging = logging;
    }


    @PostMapping
    public Log add(@RequestBody Log log){
        return logging.createLogEntry(log);
    }
}
