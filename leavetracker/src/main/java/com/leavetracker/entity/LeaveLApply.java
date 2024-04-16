package com.leavetracker.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "leaveapply")
public class LeaveLApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leaveid")
    private int leaveId;

    @Column(name = "fk_userid")
    private String userId;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;

    @Column(name = "working_days")
    private int workingDays;

    @Column(name = "fk_typeid")
    private int typeId;

    @Column(name = "reason")
    private String reason;

    // Constructors, getters, and setters

    public LeaveLApply(int leaveId, String userId, Date fromDate, Date toDate, int workingDays, int typeId, String reason) {
        this.leaveId = leaveId;
        this.userId = userId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.workingDays = workingDays;
        this.typeId = typeId;
        this.reason = reason;
    }

    public LeaveLApply() {
    }
// Getters and setters

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
