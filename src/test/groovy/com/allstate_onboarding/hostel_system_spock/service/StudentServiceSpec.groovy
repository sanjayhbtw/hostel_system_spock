package com.allstate_onboarding.hostel_system_spock.service

import com.allstate_onboarding.hostel_system_spock.exception.StudentNotFoundException
import com.allstate_onboarding.hostel_system_spock.model.Student
import com.allstate_onboarding.hostel_system_spock.repository.HostelRepository
import com.allstate_onboarding.hostel_system_spock.repository.RoomRepository
import com.allstate_onboarding.hostel_system_spock.repository.StudentRepository
import spock.lang.Specification

class StudentServiceSpec extends Specification {
    def "should get student when id is given"() {
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
}
