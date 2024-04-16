package com.leavetracker.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "departments")
    public class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "departmentid")
        private int departmentId;

        private String departmentName;

        public Department() {
        }

        public Department(int departmentId, String departmentName) {
            this.departmentId = departmentId;
            this.departmentName = departmentName;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }
    }

