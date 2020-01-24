package com.vestas.kawit.logger.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Log {

    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    private String user;
    private String module;
    private String backendStep;
    private Timestamp timestamp;

    @NotNull
    private int orderNo;
    private String orderType;

    @NotNull
    private LogTypes type;
    @NotNull
    private LogSubTypes subType;

    public Log() {
    }

    public Log(@NotEmpty String user, String module, String backendStep, Timestamp timestamp, @NotNull int orderNo, String orderType, @NotNull LogTypes type, @NotNull LogSubTypes subType) {
        this.user = user;
        this.module = module;
        this.backendStep = backendStep;
        this.timestamp = timestamp;
        this.orderNo = orderNo;
        this.orderType = orderType;
        this.type = type;
        this.subType = subType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getBackendStep() {
        return backendStep;
    }

    public void setBackendStep(String backendStep) {
        this.backendStep = backendStep;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public LogTypes getType() {
        return type;
    }

    public void setType(LogTypes type) {
        this.type = type;
    }

    public LogSubTypes getSubType() {
        return subType;
    }

    public void setSubType(LogSubTypes subType) {
        this.subType = subType;
    }
}
