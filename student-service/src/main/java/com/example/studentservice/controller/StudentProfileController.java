package com.example.studentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentservice.model.StudentProfile;
import com.example.studentservice.service.impl.StudentProfileServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api")
public class StudentProfileController {

	private StudentProfileServiceImpl service;
	
	@GetMapping("/student-profile")
	public List<StudentProfile> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/student-profile/{id}")
	public Optional<StudentProfile> findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/default")
	public String addStudent() {
		StudentProfile studentProfile = new StudentProfile();
		studentProfile.setFirstName("Default First Name");
		studentProfile.setLastName("Default Last Name");
		studentProfile.setPhoneNumber("0123456789");
		studentProfile.setEmail("default@mail.com");
		service.addStudentProfile(studentProfile);
		return "Default profile has been added successfully.";
	}
	
	@PostMapping("/add-student-profile")
	public StudentProfile addStudent(@RequestBody StudentProfile studentProfile) {
		service.addStudentProfile(studentProfile);
		return studentProfile;
	}
	
	
}
