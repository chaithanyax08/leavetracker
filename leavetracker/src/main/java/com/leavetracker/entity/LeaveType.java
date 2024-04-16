package com.leavetracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leavetype")
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeid")
    private int typeId;

    @Column(name = "typename")
    private String typeName;

    @Column(name = "maxdays")
    private int maxDays;

    // Constructors, getters, and setters

    public LeaveType() {
    }

    public LeaveType(String typeName, int maxDays) {
        this.typeName = typeName;
        this.maxDays = maxDays;
    }

    // Getters and setters

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }
}
