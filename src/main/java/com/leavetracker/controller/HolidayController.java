package com.leavetracker.controller;

import com.leavetracker.entity.Holiday;
import com.leavetracker.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @PostMapping("/createholiday")
    public ResponseEntity<String> createHoliday(@RequestBody Holiday holiday){
         holidayService.createHoliday(holiday);
         String res= "holiday created successfully";
         return  new ResponseEntity<>(res, HttpStatus.OK);
    }
    @GetMappidirng("/displayholidays")
    public List<Holiday> getHolidays(){
        return holidayService.getHoliday();
    }

    @GetMapping("/findholidaybyid/{id}")
    public ResponseEntity<String> findbyid(@PathVariable int id){
        try {
            holidayService.findHolidayById(id);
            String res= "Holiday with id " + id +  " is found";
            return new ResponseEntity<String>(res,HttpStatus.OK);

        }   catch (Exception e){
            String res= "Holidays not found";
            return new ResponseEntity<String>(res,HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteholiday/{id}")
    public ResponseEntity<String> deletebyid(@PathVariable int id){
        try {
            holidayService.findHolidayById(id);
            holidayService.deleteHoliday(id);
            String res= "Holiday with the id " + id + "is deleted ";
            return new ResponseEntity<String>(res,HttpStatus.OK);
        }
        catch (Exception e){
            String res= "Holidays not found";
            return new ResponseEntity<String>(res,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Holiday> updateHoliday(
            @PathVariable("id") int id,
            @RequestBody Holiday updatedHolidayReqBody
    ) {
        ResponseEntity<Holiday> response = holidayService.updateHoliday(id, updatedHolidayReqBody);
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }
}
