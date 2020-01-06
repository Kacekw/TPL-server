package com.vestas.kawit.task_lists.service;

import com.vestas.kawit.task_lists.repository.TaskList;
import com.vestas.kawit.task_lists.repository.TaskListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskListService {

    private final TaskListRepository taskListRepository;
    private final TaskListDTOTransformer taskListDTOTransformer;
    private final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Autowired
    public TaskListService(TaskListRepository taskListRepository, TaskListDTOTransformer taskListDTOTransformer) {
        this.taskListRepository = taskListRepository;
        this.taskListDTOTransformer = taskListDTOTransformer;
    }

    public List<TaskListDTO> getAll(@RequestParam(required = false) String plant, String taskList) {
        if (plant == null || taskList == null) {
            return supplyDataTransferObject(taskListRepository.findAll());
        }
        int id = Integer.parseInt(plant + taskList);
        return supplyDataTransferObject(taskListRepository.findAllById(Collections.singletonList(id)));
    }

    public TaskListDTO add(TaskList taskList) {
        taskList.setDate(new Date(System.currentTimeMillis()));
        taskList.setPlantAndTaskList(Integer.parseInt(taskList.getPlant() + Integer.toString(taskList.getTaskList())));
        TaskListDTO addingResult = taskListDTOTransformer.transformToDto(taskListRepository.save(taskList));
        if (addingResult == null) {
            throw new IllegalArgumentException("Could not add the task list.");
        } else {
            logger.info(String.format("%s \n%s", "New task List added!",
                    taskListDTOTransformer.transformToDto(taskList).toString()));
            return addingResult;
        }

    }

    private List<TaskListDTO> supplyDataTransferObject(List<TaskList> taskListList) {
        return taskListList.stream()
                .map(taskListDTOTransformer::transformToDto)
                .collect(Collectors.toList());
    }
}

