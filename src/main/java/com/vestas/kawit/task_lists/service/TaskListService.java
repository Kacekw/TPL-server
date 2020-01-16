package com.vestas.kawit.task_lists.service;

import com.vestas.kawit.logger.service.Log;
import com.vestas.kawit.logger.service.LogSubTypes;
import com.vestas.kawit.logger.service.LogTypes;
import com.vestas.kawit.logger.service.Logging;
import com.vestas.kawit.task_lists.repository.TaskList;
import com.vestas.kawit.task_lists.repository.TaskListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskListService {

    private final TaskListRepository taskListRepository;
    private final TaskListDTOTransformer taskListDTOTransformer;
    private final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);
    private final Logging internalLogger;

    @Autowired
    public TaskListService(TaskListRepository taskListRepository, TaskListDTOTransformer taskListDTOTransformer, Logging logging) {
        this.taskListRepository = taskListRepository;
        this.taskListDTOTransformer = taskListDTOTransformer;
        this.internalLogger = logging;
    }

    public List<TaskListDTO> getAll(@RequestParam(required = false) String plant, String taskList) {
        if (plant == null || taskList == null) {
            return supplyDataTransferObject(taskListRepository.findAll());
        }
        int id = Integer.parseInt(plant + taskList);
        return supplyDataTransferObject(taskListRepository.findAllById(Collections.singletonList(id)));
    }

    public TaskListDTO add(TaskList taskList) {
        Log log;
        log = new Log(taskList.getAuthor(), null, taskList.getDate(), taskList.getOrderNo(),
               "YM01", null, null, LogTypes.INFO, LogSubTypes.SCHEDULED);

        taskList.setDate(new Date(System.currentTimeMillis()));
        taskList.setPlantAndTaskList(Integer.parseInt(taskList.getPlant() + Integer.toString(taskList.getTaskList())));

        TaskListDTO addingResult = taskListDTOTransformer.transformToDto(taskListRepository.save(taskList));
        if (addingResult == null) {
            throw new IllegalArgumentException("Could not add the task list.");
        } else {
            logger.info(String.format("%s \n%s", "New task List added!",
                    taskListDTOTransformer.transformToDto(taskList).toString()));
            internalLogger.createLogEntry(log);
            return addingResult;
        }

    }

    //TODO implement that method in controller
    public void remove(TaskList taskList){
        try{
            taskListRepository.delete(taskList);
        }catch(IllegalArgumentException iae){
            logger.error(iae.getMessage());
        }
    }

    private List<TaskListDTO> supplyDataTransferObject(List<TaskList> taskListList) {
        return taskListList.stream()
                .map(taskListDTOTransformer::transformToDto)
                .collect(Collectors.toList());
    }
}

