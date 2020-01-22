package com.vestas.kawit.task_lists.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskListRepository extends JpaRepository<TaskList, Integer> {

    List<TaskList> findByPlantAndTaskList(int plant, int taskList);

}
