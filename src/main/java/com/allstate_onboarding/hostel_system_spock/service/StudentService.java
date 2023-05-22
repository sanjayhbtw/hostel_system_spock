package com.allstate_onboarding.hostel_system_spock.service;


import com.allstate_onboarding.hostel_system_spock.model.Hostel;
import com.allstate_onboarding.hostel_system_spock.model.Room;
import com.allstate_onboarding.hostel_system_spock.model.Student;
import com.allstate_onboarding.hostel_system_spock.repository.HostelRepository;
import com.allstate_onboarding.hostel_system_spock.repository.RoomRepository;
import com.allstate_onboarding.hostel_system_spock.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final HostelRepository hostelRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, HostelRepository hostelRepository, RoomRepository roomRepository) {
        this.studentRepository = studentRepository;
        this.hostelRepository = hostelRepository;
        this.roomRepository = roomRepository;
    }

    public Student getStudent(Integer integer) {
        return studentRepository.findById(integer).orElseThrow();
    }

    public void updateMonthlyExpensesFor(Integer id) {
        Hostel hostel = hostelRepository.findByStudentId(id);
        Room room = roomRepository.findById(hostel.getRoomId()).orElseThrow();
    }
}
