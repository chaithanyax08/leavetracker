package com.leavetracker.service;

import com.leavetracker.entity.LeaveLApply;
import com.leavetracker.repository.LeaveApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
@Service
public class LeaveApplyService {

    @Autowired
    private LeaveApplyRepository leaveApplyRepository;

    public int calculateWorkingDays(LocalDate fromDate, LocalDate toDate) {
        int workingDays = 0;

        for (LocalDate currentDate = fromDate; !currentDate.isAfter(toDate); currentDate = currentDate.plusDays(1)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
                workingDays++;
            }
        }
        return workingDays;
    }

    public LeaveLApply applyLeave(LeaveLApply leaveApply) {

        LocalDate fromDate = leaveApply.getFromDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate toDate = leaveApply.getToDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        int workingDays = calculateWorkingDays(fromDate, toDate);
        leaveApply.setWorkingDays(workingDays);


        return leaveApplyRepository.save(leaveApply);


    }

    public List<LeaveLApply> getLeaveApply(){
        return leaveApplyRepository.findAll();
    }




}
