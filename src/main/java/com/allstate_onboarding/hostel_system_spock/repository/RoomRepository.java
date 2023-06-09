package com.allstate_onboarding.hostel_system_spock.repository;

import com.allstate_onboarding.hostel_system_spock.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
