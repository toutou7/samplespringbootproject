package com.example.studentservice.service;

import java.util.List;
import java.util.Optional;

import com.example.studentservice.model.APIResponse;
import com.example.studentservice.model.StudentProfile;

public interface StudentProfileService {
	
	List<StudentProfile> findAll();
	Optional<StudentProfile> findById(Long id);
	String addDefault();
	void addStudentProfile(StudentProfile studentProfile);
	void updateStudentProfile(Long id, StudentProfile studentProfile);
	void deleteStudentProfile(Long id);
	APIResponse test(Long id);

}
