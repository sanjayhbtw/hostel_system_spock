package com.allstate_onboarding.hostel_system_spock.controller;


import com.allstate_onboarding.hostel_system_spock.exception.StudentNotFoundException;
import com.allstate_onboarding.hostel_system_spock.model.Student;
import com.allstate_onboarding.hostel_system_spock.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Integer id) throws StudentNotFoundException {
        return studentService.getStudent(id);
    }

//
//    @PatchMapping("/students/{id}/update_monthly_expense")
//    public Student updateMonthlyExpenseBasedOnHostelAndRoomAmenities(@PathVariable Integer id) throws StudentNotFoundException {
//        studentService.updateMonthlyExpensesFor(id);
//        return studentService.getStudent(id);
//    }
}
