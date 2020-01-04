package com.vestas.kawit.task_lists.controller;

import com.vestas.kawit.task_lists.repository.TaskList;
import com.vestas.kawit.task_lists.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/tasklist")
@RestController
public class TaskListController {

    private final TaskListService taskListService;

    @Autowired
    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @PostMapping
    public TaskList add(@Valid @RequestBody TaskList taskList){
        return taskListService.add(taskList);
    }
}
