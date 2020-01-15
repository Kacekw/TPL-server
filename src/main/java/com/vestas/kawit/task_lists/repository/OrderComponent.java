package com.vestas.kawit.task_lists.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class OrderComponent {

    @Id @GeneratedValue
    private int id;
    @NotEmpty
    private String componentNo;
    @NotEmpty
    private String description;
    private int requirement;
    @NotEmpty
    private String itemCategory;
    @NotEmpty
    private String operation;
    @NotEmpty
    private String reservation;

    public OrderComponent() {
    }

    public OrderComponent(@NotEmpty String componentNo, @NotEmpty String description, int requirement, @NotEmpty String itemCategory, @NotEmpty String operation, @NotEmpty String reservation) {
        this.componentNo = componentNo;
        this.description = description;
        this.requirement = requirement;
        this.itemCategory = itemCategory;
        this.operation = operation;
        this.reservation = reservation;
    }

    private int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private String getComponentNo() {
        return componentNo;
    }

    private void setComponentNo(String componentNo) {
        this.componentNo = componentNo;
    }

    private String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private int getRequirement() {
        return requirement;
    }

    private void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    private String getItemCategory() {
        return itemCategory;
    }

    private void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    private String getOperation() {
        return operation;
    }

    private void setOperation(String operation) {
        this.operation = operation;
    }

    private String getReservation() {
        return reservation;
    }

    private void setReservation(String reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return String.format("\n%s | %s | %s | %s | %s | %s",
                getComponentNo(), getDescription(), getRequirement(), getItemCategory(), getOperation(), getReservation());
    }
}
