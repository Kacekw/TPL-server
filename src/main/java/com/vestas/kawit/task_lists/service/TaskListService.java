package com.vestas.kawit.task_lists.service;

import com.vestas.kawit.task_lists.repository.TaskList;
import com.vestas.kawit.task_lists.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

@Service
public class TaskListService {

    private final TaskListRepository taskListRepository;

    @Autowired
    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    public List<TaskList> getAll(@RequestParam(required = false) String plant, String taskList){
        if (plant != null && taskList != null){
            return taskListRepository.findAllById(Collections.singletonList(Integer.parseInt(plant + taskList)));
        }
        return taskListRepository.findAll();
    }

    public TaskList add(TaskList taskList) {
        taskList.setDate(new Date(System.currentTimeMillis()));
        taskList.setPlantAndTaskList(Integer.parseInt(taskList.getPlant() + Integer.toString(taskList.getTaskList())));
        return taskListRepository.save(taskList);
    }
}

