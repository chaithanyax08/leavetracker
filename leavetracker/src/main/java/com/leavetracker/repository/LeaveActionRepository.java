package com.leavetracker.repository;

import com.leavetracker.entity.LeaveAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveActionRepository extends JpaRepository<LeaveAction, Integer> {
}
