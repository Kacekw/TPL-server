package com.vestas.kawit.task_lists.repository;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class TaskList {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private int plant;
    @Column(name = "task_list_group_number")
    private int taskList;
    @NotNull
    @NotEmpty(message = "Long text cannot be empty.")
    @Column(name = "long_text", columnDefinition = "LONGTEXT")
    private String longText;

    @NotEmpty(message = "Operations cannot be empty.")
    @ElementCollection(targetClass = OrderOperation.class)
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderOperation> operations;

    @ElementCollection(targetClass = OrderComponent.class)
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderComponent> components;

    private Timestamp timestamp;

    @NotEmpty
    private String author;

    @Column(name = "order_no")
    private int orderNo;

    public TaskList() {
    }

    public TaskList(int plant, int taskList, @NotEmpty(message = "Long text cannot be empty.") String longText, @NotEmpty(message = "Operations cannot be empty.") List<OrderOperation> operations, List<OrderComponent> components, Timestamp timestamp, @NotEmpty String author, int orderNo) {
        this.plant = plant;
        this.taskList = taskList;
        this.longText = longText;
        this.operations = operations;
        this.components = components;
        this.timestamp = timestamp;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
}
