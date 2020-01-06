package com.vestas.kawit.task_lists.repository;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.util.List;

@Entity
public class TaskList {

    private int plant;
    private int taskList;
    @Id
    private int plantAndTaskList;

    @NotNull
    @NotEmpty(message = "Long text cannot be empty.")
    private String longText;
    @NotEmpty(message = "Operations cannot be empty.")
    @ElementCollection(targetClass = OrderOperation.class)
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderOperation> operations;
    @ElementCollection(targetClass = OrderComponent.class)
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderComponent> components;

    private Date date;

    @NotEmpty
    private String author;

    private float orderNo;

    public TaskList() {
    }

    public TaskList(int plant, int taskList, int plantAndTaskList, @NotNull @NotEmpty(message = "Long text cannot be empty.") String longText, @NotEmpty(message = "Operations cannot be empty.") List<OrderOperation> operations, List<OrderComponent> components, Date date, @NotEmpty String author, float orderNo) {
        this.plant = plant;
        this.taskList = taskList;
        this.longText = longText;
        this.operations = operations;
        this.components = components;
        this.date = date;
        this.plantAndTaskList = plantAndTaskList;
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

    public int getPlantAndTaskList() {
        return plantAndTaskList;
    }

    public void setPlantAndTaskList(int plantAndTaskList) {
        this.plantAndTaskList = plantAndTaskList;
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

    public float getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(float orderNo) {
        this.orderNo = orderNo;
    }
}
