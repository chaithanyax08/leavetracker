package com.leavetracker.service;

import com.leavetracker.entity.Holiday;
import com.leavetracker.exception.HolidayNotFoundException;
import com.leavetracker.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    public Holiday createHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    public List<Holiday> getHoliday() {
        return holidayRepository.findAll();
    }

    public Holiday findHolidayById(int id) {
        Optional<Holiday> optionalHoliday = holidayRepository.findById(id);
        return optionalHoliday.orElseThrow(() -> new HolidayNotFoundException("Holiday not found"));
    }

    public void deleteHoliday(int holidayid) {
        holidayRepository.deleteById(holidayid);
    }
    public ResponseEntity<Holiday> updateHoliday(int id,Holiday updatedHolidayReqBody) {

         Holiday existingHoliday = findHolidayById(id);

        if (existingHoliday == null) {

            throw new HolidayNotFoundException("Holiday with ID " + id + " not found");

        }
        if (updatedHolidayReqBody.getDate() != null) {
        existingHoliday.setDate(updatedHolidayReqBody.getDate());
        }

        if (updatedHolidayReqBody.getDescription() != null) {
            existingHoliday.setDescription(updatedHolidayReqBody.getDescription());
        }
        if (updatedHolidayReqBody.getCreatedAt() != null) {
            existingHoliday.setCreatedAt(updatedHolidayReqBody.getCreatedAt());
        }
        if (updatedHolidayReqBody.getUpdatedAt() != null) {
            existingHoliday.setUpdatedAt(updatedHolidayReqBody.getUpdatedAt());
        }
        if (updatedHolidayReqBody.getDeletedAt() != null) {
            existingHoliday.setDeletedAt(updatedHolidayReqBody.getDeletedAt());
        }

        if (updatedHolidayReqBody.getCreatedBy() != null) {
            existingHoliday.setCreatedBy(updatedHolidayReqBody.getCreatedBy());
        }
        if (updatedHolidayReqBody.getUpdatedBy() != null) {
            existingHoliday.setUpdatedBy(updatedHolidayReqBody.getUpdatedBy());
        }
        if (updatedHolidayReqBody.getDeletedBy() != null) {
            existingHoliday.setDeletedBy(updatedHolidayReqBody.getDeletedBy());
        }

      Holiday updatedHoliday = holidayRepository.save(existingHoliday);

        return new ResponseEntity<>(updatedHoliday, HttpStatus.OK);

    }

}




