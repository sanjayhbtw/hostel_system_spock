package com.allstate_onboarding.hostel_system_spock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "room")
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "occupancy_charges")
    private Integer occupancyCharges;


    @Column(name = "room_charges")
    private Integer roomCharges;


    @Column(name = "power_backup_charges")
    private Integer powerBackupCharges;

    @Column(name = "mess_charges")
    private Integer messCharges;


    public Integer getAllCharges() {
        return occupancyCharges + roomCharges + powerBackupCharges + messCharges;
    }
}
