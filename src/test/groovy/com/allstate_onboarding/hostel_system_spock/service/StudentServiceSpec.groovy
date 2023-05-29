package com.allstate_onboarding.hostel_system_spock.service

import com.allstate_onboarding.hostel_system_spock.entity.Hostel
import com.allstate_onboarding.hostel_system_spock.entity.Room
import com.allstate_onboarding.hostel_system_spock.exception.StudentNotFoundException
import com.allstate_onboarding.hostel_system_spock.entity.Student
import com.allstate_onboarding.hostel_system_spock.repository.HostelRepository
import com.allstate_onboarding.hostel_system_spock.repository.RoomRepository
import com.allstate_onboarding.hostel_system_spock.repository.StudentRepository
import spock.lang.Specification

class StudentServiceSpec extends Specification {
    def "should get student when student with given id is present"() {
        Integer id = 1
        def expected = Optional.of(new Student(1, "joe", 0))
        def studentRepository = Mock(StudentRepository)
        def service = new StudentService(studentRepository, Mock(HostelRepository), Mock(RoomRepository))

        when:
        def actual = service.getStudent(id)

        then:
        1 * studentRepository.findById(id) >> expected
        actual == expected.get()
    }

    def "should throw an error if student with given id is not found"() {
        Integer id = 1
        def studentRepository = Mock(StudentRepository)
        def service = new StudentService(studentRepository, Mock(HostelRepository), Mock(RoomRepository))

        when:
        service.getStudent(id)

        then:
        1 * studentRepository.findById(id) >> Optional.empty()
        thrown(StudentNotFoundException)
    }

    def "should update monthly expenses of a student when student with given id is present"() {
        Integer id = 1
        def studentRepository = Mock(StudentRepository)
        def hostelRepository = Mock(HostelRepository)
        def roomRepository = Mock(RoomRepository)
        def service = new StudentService(studentRepository, hostelRepository, roomRepository)

        when:
        service.updateMonthlyExpensesFor(id)

        then:
        1 * studentRepository.findById(id) >> Optional.of(new Student(1, "joe", 0))
        1 * hostelRepository.findByStudentId(id) >> new Hostel(1, 2, 1, 1000)
        1 * roomRepository.findById(2) >>
                Optional.of(
                        new Room(2, 2500, 3000, 5000, 1500)
                )
        1 * studentRepository.save(new Student(1, "joe", 13000))
    }
}
