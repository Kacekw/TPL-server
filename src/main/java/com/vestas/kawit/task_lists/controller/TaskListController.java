package com.vestas.kawit.task_lists.controller;

import com.vestas.kawit.task_lists.repository.TaskList;
import com.vestas.kawit.task_lists.service.TaskListDTO;
import com.vestas.kawit.task_lists.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/tasklist")
@RestController
public class TaskListController {

    private final TaskListService taskListService;

    @Autowired
    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @GetMapping
    public List<TaskListDTO> getAllTaskLists(@RequestParam(required = false) String plant, String taskList) {
        return taskListService.getAll(plant, taskList);
    }

    @PostMapping
    public TaskListDTO add(@Valid @RequestBody TaskList taskList) {
        return taskListService.add(taskList);
    }
}
