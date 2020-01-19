package com.vestas.kawit.task_lists.service;

import com.vestas.kawit.task_lists.repository.OrderComponent;
import com.vestas.kawit.task_lists.repository.OrderOperation;

import java.sql.Date;
import java.util.List;

public class TaskListDTO {

    private int plant;
    private int taskList;

    private String longText;
    private List<OrderOperation> operations;
    private List<OrderComponent> components;

    private Date date;
    private String author;
    private int orderNo;

    public TaskListDTO(int plant, int taskList, String longText, List<OrderOperation> operations, List<OrderComponent> components, Date date, String author, int orderNo) {
        this.plant = plant;
        this.taskList = taskList;
        this.longText = longText;
        this.operations = operations;
        this.components = components;
        this.date = date;
        this.author = author;
        this.orderNo = orderNo;
    }

    public int getPlant() {
        return plant;
    }

    public void setPlant(int plant) {
        this.plant = plant;
    }

    public int getTaskList() {
        return taskList;
    }

    public void setTaskList(int taskList) {
        this.taskList = taskList;
    }

    public String getLongText() {
        return longText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public List<OrderOperation> getOperations() {
        return operations;
    }

    public void setOperations(List<OrderOperation> operations) {
        this.operations = operations;
    }

    public List<OrderComponent> getComponents() {
        return components;
    }

    public void setComponents(List<OrderComponent> components) {
        this.components = components;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return String.format("Created by %s on %s\n" +
                "Plant %s\n" +
                "Task list no %s\n" +
                "Long text: \n%s\n" +
                "Operations: %s\n" +
                "Components: %s\n" +
                "Order no: %s",
                getAuthor(), getDate(),
                getPlant(),
                getTaskList(),
                getLongText(),
                getOperations(),
                getComponents(),
                getOrderNo());
    }
}
