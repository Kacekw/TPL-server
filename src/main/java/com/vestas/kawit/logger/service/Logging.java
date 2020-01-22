package com.vestas.kawit.logger.service;

import com.vestas.kawit.logger.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Logging {

    private final LogRepository logRepository;

    @Autowired
    public Logging(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public Log createLogEntry(Log log) {
        return logRepository.save(log);
    }
}
