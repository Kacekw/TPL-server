package com.vestas.kawit.logger.service;

import com.vestas.kawit.logger.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.List;

@Service
public class Logging {

    private final LogRepository logRepository;

    @Autowired
    public Logging(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public Log createLogEntry(Log log) {
        log.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return logRepository.save(log);
    }

    public List<Log> getLogs(){
        return logRepository.findAll();
    }

    public ModelAndView viewLogs(){
        ModelAndView mvc = new ModelAndView("log/logs");
        mvc.addObject("LogsCollection", logRepository.findAll(Sort.by(Sort.Direction.DESC, "timestamp")));
        return mvc;
    }
}
