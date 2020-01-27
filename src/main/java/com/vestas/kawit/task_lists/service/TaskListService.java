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
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskListService {

    private final TaskListRepository taskListRepository;
    private final TaskListDTOTransformer taskListDTOTransformer;
    private final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);
    private final Logging internalLogger;

    static final String ADDING_TASK_LIST_TO_DATABASE_ERROR = "Could not add the task list.";
    static final String READING_TASK_LIST_FROM_DATABASE_ERROR = "Could not find the task list.";
    static final String READING_TASK_LIST_FROM_DATABASE_SUCCESS = "Task list was found.";
    static final String ADDING_TASK_LIST_TO_DATABASE_SUCCESS = "New task List added!";
    static final String ADDING_TASK_LIST_ALREADY_IN_DATABASE = "Task list already in database, old task list is about to be deleted.";
    static final String SCHEDULED_SERVICE_MODULE_SAVING_TASK_LIST = "saving task list";
    static final String SCHEDULED_SERVICE_MODULE_READING_TASK_LIST = "reading task list";

    @Autowired
    public TaskListService(TaskListRepository taskListRepository, TaskListDTOTransformer taskListDTOTransformer, Logging logging) {
        this.taskListRepository = taskListRepository;
        this.taskListDTOTransformer = taskListDTOTransformer;
        this.internalLogger = logging;
    }

    public List<TaskListDTO> getAll(String userMakingRequest, String plant, String taskList) {
        List<TaskListDTO> getAllResult;

        Log log = new Log(userMakingRequest,
                SCHEDULED_SERVICE_MODULE_READING_TASK_LIST,
                null,
                null,
                0,
                "YM01",
                LogTypes.INFO,
                LogSubTypes.SCHEDULED,
        null);

        if (plant == null || taskList == null) {
            getAllResult = supplyDataTransferObject(taskListRepository.findAll());
        } else {
            getAllResult = supplyDataTransferObject(taskListRepository.findByPlantAndTaskList(Integer.parseInt(plant), Integer.parseInt(taskList)));
            if (!getAllResult.isEmpty()) {
                log.setOrderNo(getAllResult.get(0).getOrderNo());
                log.setAdditionalDescription(READING_TASK_LIST_FROM_DATABASE_SUCCESS);
            }
            else{
                log.setType(LogTypes.ERROR);
                log.setAdditionalDescription(READING_TASK_LIST_FROM_DATABASE_ERROR);
                throw new NoSuchElementException(READING_TASK_LIST_FROM_DATABASE_ERROR);
            }
        }

        internalLogger.createLogEntry(log);

        return getAllResult;
    }

    public TaskListDTO add(TaskList taskList) {
        taskList.setTimestamp(new Timestamp(System.currentTimeMillis()));

        Log log = new Log(taskList.getAuthor(),
                SCHEDULED_SERVICE_MODULE_SAVING_TASK_LIST,
               null,
                null,
                taskList.getOrderNo(),
                "YM01",
                null,
                LogSubTypes.SCHEDULED,
                null);

        TaskList findIfAlreadyInDatabase = taskListRepository.findFirstByPlantAndTaskList(taskList.getPlant(), taskList.getTaskList());
        if (findIfAlreadyInDatabase != null){
            logger.info(ADDING_TASK_LIST_ALREADY_IN_DATABASE);
            remove(findIfAlreadyInDatabase);
        }

        TaskListDTO addingResult = taskListDTOTransformer.transformToDto(taskListRepository.save(taskList));

        if (addingResult == null) {
            logger.error(ADDING_TASK_LIST_TO_DATABASE_ERROR);
            log.setType(LogTypes.ERROR);
            internalLogger.createLogEntry(log);

            throw new IllegalArgumentException(ADDING_TASK_LIST_TO_DATABASE_ERROR);
        } else {
            logger.info(ADDING_TASK_LIST_TO_DATABASE_SUCCESS);
            log.setType(LogTypes.INFO);
            internalLogger.createLogEntry(log);
            return addingResult;
        }
    }

    public void remove(TaskList taskList) {
        try {
            taskListRepository.delete(taskList);
        } catch (IllegalArgumentException iae) {
            logger.error(iae.getMessage());
        }
    }

    private List<TaskListDTO> supplyDataTransferObject(List<TaskList> taskListList) {
        return taskListList.stream()
                .map(taskListDTOTransformer::transformToDto)
                .collect(Collectors.toList());
    }
}

