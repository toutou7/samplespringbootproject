package com.example.studentservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentservice.model.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

}
