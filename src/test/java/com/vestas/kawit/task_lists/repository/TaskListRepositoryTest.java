package com.vestas.kawit.task_lists.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TaskListRepositoryTest {

    @Autowired
    private TaskListRepository taskListRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void if_there_is_no_elements_in_db_then_returned_list_from_db_should_be_empty(){
        //given

        //when
        List<TaskList> taskListList = taskListRepository.findAll();
        //then
        assertEquals(0, taskListList.size());
    }
}