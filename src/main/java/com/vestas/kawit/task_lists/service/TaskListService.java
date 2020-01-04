package com.vestas.kawit.task_lists.service;

import com.vestas.kawit.task_lists.repository.TaskList;
import com.vestas.kawit.task_lists.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskListService {

    private final TaskListRepository taskListRepository;

    @Autowired
    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    public TaskList add(TaskList taskList) {
        return taskListRepository.save(taskList);
    }
}

