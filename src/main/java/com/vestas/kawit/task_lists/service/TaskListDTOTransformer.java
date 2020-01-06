package com.vestas.kawit.task_lists.service;

import com.vestas.kawit.task_lists.repository.TaskList;
import org.springframework.stereotype.Component;

@Component
public class TaskListDTOTransformer {

    public TaskListDTO transformToDto(TaskList taskList){
        TaskListDTO dataTransferObject;
        dataTransferObject = new TaskListDTO(
                taskList.getPlant(),
                taskList.getTaskList(),
                taskList.getLongText(),
                taskList.getOperations(),
                taskList.getComponents(),
                taskList.getDate(),
                taskList.getAuthor()
        );

        return dataTransferObject;
    }
}
