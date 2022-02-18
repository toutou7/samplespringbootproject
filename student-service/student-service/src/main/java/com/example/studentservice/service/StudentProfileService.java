package com.example.studentservice.service;

import java.util.List;
import java.util.Optional;

import com.example.studentservice.model.StudentProfile;

public interface StudentProfileService {
	
	List<StudentProfile> findAll();
	Optional<StudentProfile> findById(Long id);
	void addStudentProfile(StudentProfile studentProfile);
	
}
