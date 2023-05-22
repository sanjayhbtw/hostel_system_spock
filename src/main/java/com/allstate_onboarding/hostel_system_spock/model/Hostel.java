package com.allstate_onboarding.hostel_system_spock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "hostel")
@Table(name = "hostels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hostel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "monthly_charges")
    private Integer monthlyCharges;
}
