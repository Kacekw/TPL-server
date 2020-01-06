package com.vestas.kawit.task_lists.repository;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class OrderOperation {

    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    @Length(min = 4, max = 4)
    private String operation;
    @NotEmpty
    @Length(max = 40)
    private String operationShortText;
    @NotNull
    private int workingHours;
    @Min(1)
    private int numberOfTechnicians;

    public OrderOperation() {
    }

    public OrderOperation(@NotEmpty @Length(min = 4, max = 4) String operation, @NotEmpty @Length(max = 40) String operationShortText, @NotNull int workingHours, @Min(1) int numberOfTechnicians) {
        this.operation = operation;
        this.operationShortText = operationShortText;
        this.workingHours = workingHours;
        this.numberOfTechnicians = numberOfTechnicians;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperationShortText() {
        return operationShortText;
    }

    public void setOperationShortText(String operationShortText) {
        this.operationShortText = operationShortText;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getNumberOfTechnicians() {
        return numberOfTechnicians;
    }

    public void setNumberOfTechnicians(int numberOfTechnicians) {
        this.numberOfTechnicians = numberOfTechnicians;
    }

    @Override
    public String toString() {
        return String.format("\n%s | %s | %s | %s",
                getOperation(), getOperationShortText(), getNumberOfTechnicians(), getWorkingHours());
    }
}
