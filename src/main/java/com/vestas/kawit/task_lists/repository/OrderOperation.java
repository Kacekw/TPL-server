package com.vestas.kawit.task_lists.repository;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
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
    @Column(name = "operation_short_text")
    private String operationShortText;
    @NotNull
    @Column(name = "working_hours:")
    private int workingHours;
    @Min(1)
    @Column(name = "number_of_technicians")
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

    private String getOperation() {
        return operation;
    }

    private void setOperation(String operation) {
        this.operation = operation;
    }

    private String getOperationShortText() {
        return operationShortText;
    }

    private void setOperationShortText(String operationShortText) {
        this.operationShortText = operationShortText;
    }

    private int getWorkingHours() {
        return workingHours;
    }

    private void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    private int getNumberOfTechnicians() {
        return numberOfTechnicians;
    }

    private void setNumberOfTechnicians(int numberOfTechnicians) {
        this.numberOfTechnicians = numberOfTechnicians;
    }

    @Override
    public String toString() {
        return String.format("\n%s | %s | %s | %s",
                getOperation(), getOperationShortText(), getNumberOfTechnicians(), getWorkingHours());
    }
}
