package com.vestas.kawit.task_lists.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class OrderComponent {

    @Id @GeneratedValue
    private int id;
    @NotEmpty
    @Column(name = "component_no")
    private String componentNo;
    @NotEmpty
    private String description;
    private String requirement;
    @NotEmpty
    @Column(name = "item_category")
    private String itemCategory;
    @NotEmpty
    private String operation;
    @NotEmpty
    private String reservation;

    public OrderComponent() {
    }

    public OrderComponent(@NotEmpty String componentNo, @NotEmpty String description, String requirement, @NotEmpty String itemCategory, @NotEmpty String operation, @NotEmpty String reservation) {
        this.componentNo = componentNo;
        this.description = description;
        this.requirement = requirement;
        this.itemCategory = itemCategory;
        this.operation = operation;
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String getComponentNo() {
        return componentNo;
    }

    public void setComponentNo(String componentNo) {
        this.componentNo = componentNo;
    }

    private String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    private String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    private String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    private String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return String.format("\n%s | %s | %s | %s | %s | %s",
                getComponentNo(), getDescription(), getRequirement(), getItemCategory(), getOperation(), getReservation());
    }
}
