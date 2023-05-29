package com.allstate_onboarding.hostel_system_spock.service;


import com.allstate_onboarding.hostel_system_spock.exception.StudentNotFoundException;
import com.allstate_onboarding.hostel_system_spock.entity.Hostel;
import com.allstate_onboarding.hostel_system_spock.entity.Room;
import com.allstate_onboarding.hostel_system_spock.entity.Student;
import com.allstate_onboarding.hostel_system_spock.repository.HostelRepository;
import com.allstate_onboarding.hostel_system_spock.repository.RoomRepository;
import com.allstate_onboarding.hostel_system_spock.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static final String STUDENT_NOT_FOUND_EXCEPTION_TEMPLATE = "student with id %s not found";

    private final StudentRepository studentRepository;
    private final HostelRepository hostelRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, HostelRepository hostelRepository, RoomRepository roomRepository) {
        this.studentRepository = studentRepository;
        this.hostelRepository = hostelRepository;
        this.roomRepository = roomRepository;
    }

    public Student getStudent(Integer studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(String.format(STUDENT_NOT_FOUND_EXCEPTION_TEMPLATE, studentId)));
    }

    public void updateMonthlyExpensesFor(Integer studentId) {
        // TODO: add test for student not found
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new StudentNotFoundException(String.format(STUDENT_NOT_FOUND_EXCEPTION_TEMPLATE, studentId)));

        // TODO: add test for student with id not found in the hostel
        Hostel hostel = hostelRepository.findByStudentId(studentId);

        // TODO: add test for room not found
        Room room = roomRepository.findById(hostel.getRoomId()).orElseThrow();

        student.setMonthlyExpenses(
                hostel.getMonthlyCharges() + room.getAllCharges()
        );
        studentRepository.save(student);
    }
}
