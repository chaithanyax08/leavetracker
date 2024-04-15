package com.leavetracker.repository;

import com.leavetracker.entity.LeaveLApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveApplyRepository extends JpaRepository<LeaveLApply, Integer> {
}
