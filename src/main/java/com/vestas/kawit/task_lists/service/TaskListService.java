package com.vestas.kawit.task_lists.service;

import com.vestas.kawit.task_lists.repository.TaskList;
import com.vestas.kawit.task_lists.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class TaskListService {

    private final TaskListRepository taskListRepository;

    @Autowired
    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    public TaskList add(TaskList taskList) {
        taskList.setDate(new Date(System.currentTimeMillis()));
        taskList.setPlantAndTaskList(Integer.parseInt(taskList.getPlant() + Integer.toString(taskList.getTaskList())));
        return taskListRepository.save(taskList);
    }
}

