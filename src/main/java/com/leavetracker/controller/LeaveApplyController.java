package com.leavetracker.controller;

import com.leavetracker.entity.LeaveLApply;
import com.leavetracker.service.LeaveApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RestController
public class LeaveApplyController {

    @Autowired
    private LeaveApplyService leaveApplyService;

    @PostMapping("/apply")
    public ResponseEntity<String> applyLeave(@RequestBody LeaveLApply leaveApply){
        LocalDate fromDate = leaveApply.getFromDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate toDate = leaveApply.getToDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        int workingDays = leaveApplyService.calculateWorkingDays(fromDate, toDate);

        leaveApply.setWorkingDays(workingDays);

        leaveApplyService.applyLeave(leaveApply);
        String res= "Leave applied successfully";
        return  new ResponseEntity<>(res, HttpStatus.OK);

//        try {
//            leaveApplyService.applyLeave(leaveApply);
//            return ResponseEntity.ok ("Leave applied successfully.");
//        }catch(Exception e) {
//            return ResponseEntity.status (HttpStatus.INTERNAL_SERVER_ERROR).body ("Error in appling leave ");
//        }
    }

    @GetMapping("/leaveDetail")
    public List<LeaveLApply> getLeaveDetails(){
        return leaveApplyService.getLeaveApply();
    }
}
