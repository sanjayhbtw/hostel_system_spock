package com.allstate_onboarding.hostel_system_spock.repository;

import com.allstate_onboarding.hostel_system_spock.entity.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostelRepository extends JpaRepository<Hostel, Integer> {
    Hostel findByStudentId(Integer studentId);
}
