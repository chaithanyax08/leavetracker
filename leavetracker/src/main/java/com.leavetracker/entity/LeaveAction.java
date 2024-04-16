package com.leavetracker.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "leaveaction")
public class LeaveAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leaveactionid")
    private int leaveActionId;

    @Column(name = "fk_leaveid")
    private int leaveId;

    @Column(name = "fk_approved_by")
    private String approvedBy;

    @Column(name = "approved_datetime")
    private Date approvedDateTime;

    @Column(name = "fk_rejected_by")
    private String rejectedBy;

    @Column(name = "reject_datetime")
    private Date rejectDateTime;

    @Column(name = "reject_reason")
    private String rejectReason;

    // Constructors, getters, and setters

    public LeaveAction() {
    }

    public LeaveAction(int leaveId, String approvedBy, Date approvedDateTime, String rejectedBy, Date rejectDateTime, String rejectReason) {
        this.leaveId = leaveId;
        this.approvedBy = approvedBy;
        this.approvedDateTime = approvedDateTime;
        this.rejectedBy = rejectedBy;
        this.rejectDateTime = rejectDateTime;
        this.rejectReason = rejectReason;
    }

    // Getters and setters

    public int getLeaveActionId() {
        return leaveActionId;
    }

    public void setLeaveActionId(int leaveActionId) {
        this.leaveActionId = leaveActionId;
    }

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApprovedDateTime() {
        return approvedDateTime;
    }

    public void setApprovedDateTime(Date approvedDateTime) {
        this.approvedDateTime = approvedDateTime;
    }

    public String getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(String rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public Date getRejectDateTime() {
        return rejectDateTime;
    }

    public void setRejectDateTime(Date rejectDateTime) {
        this.rejectDateTime = rejectDateTime;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
}