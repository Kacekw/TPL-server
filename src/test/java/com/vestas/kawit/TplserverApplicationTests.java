package com.vestas.kawit;

import com.vestas.kawit.logger.repository.LogRepository;
import com.vestas.kawit.logger.service.Logging;
import com.vestas.kawit.task_lists.repository.OrderComponent;
import com.vestas.kawit.task_lists.repository.OrderOperation;
import com.vestas.kawit.task_lists.repository.TaskList;
import com.vestas.kawit.task_lists.repository.TaskListRepository;
import com.vestas.kawit.task_lists.service.TaskListDTOTransformer;
import com.vestas.kawit.task_lists.service.TaskListService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class TplserverApplicationTests {

    @Mock
    TaskListRepository taskListRepository;
    @Mock
    LogRepository logRepository;


    @Test
    public void check_if_object_was_saved_in_repository() {
        //given
        TaskListService taskListService = new TaskListService(taskListRepository, new TaskListDTOTransformer(), new Logging(logRepository));
        OrderOperation orderOperation = new OrderOperation("0010", "short text example", 21, 3);
        List<OrderOperation> orderOperationsList = new ArrayList<>();

        OrderComponent orderComponent = new OrderComponent("123123", "description", "3", "L", "0020", "Never");
        List<OrderComponent> orderComponentList = new ArrayList<>();

        orderComponentList.add(orderComponent);
        orderOperationsList.add(orderOperation);

        final TaskList taskList = new TaskList(3210, 15601,"the long text goes here",
                orderOperationsList, orderComponentList, null, "KAWIT", 0);

        //when
        Mockito.when(taskListRepository.save(any())).thenReturn(taskList);
        taskListService.add(taskList);
        //then
        Mockito.verify(taskListRepository).save(taskList);
    }

/*    @Test
    public void test_if_removal_method_removes(){
        //given
        TaskListService taskListService = new TaskListService(taskListRepository, new TaskListDTOTransformer(), new Logging(logRepository));
        OrderOperation orderOperation = new OrderOperation("0010", "short text example", 21, 3);
        List<OrderOperation> orderOperationsList = new ArrayList<>();

        OrderComponent orderComponent = new OrderComponent("123123", "description", 3, "L", "0020", "Never");
        List<OrderComponent> orderComponentList = new ArrayList<>();

        orderComponentList.add(orderComponent);
        orderOperationsList.add(orderOperation);

        final TaskList taskList = new TaskList(3210, 15601, 0, "the long text goes here",
                orderOperationsList, orderComponentList, null, "KAWIT", 0);

        //when
        Mockito.when(taskListRepository.delete(taskList)).

    }*/
}




























