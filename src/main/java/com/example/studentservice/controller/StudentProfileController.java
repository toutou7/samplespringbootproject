package com.example.studentservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.studentservice.model.APIResponse;
import org.springframework.web.bind.annotation.*;

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
	public String addDefault() {
		StudentProfile studentProfile = new StudentProfile();
		studentProfile.setFirstName("Default First Name");
		studentProfile.setLastName("Default Last Name");
		studentProfile.setPhoneNumber("0123456789");
		studentProfile.setEmail("default@mail.com");

		List<String> course = new ArrayList<>();
		course.add("Math");
		course.add("Programming");
		course.add("Physics");
		course.add("Engineering");
		studentProfile.setCourse(course);

		service.addStudentProfile(studentProfile);
		return "Default profile has been added";
	}
	
	@PostMapping("/add-student-profile")
	public StudentProfile addStudentProfile(@RequestBody StudentProfile studentProfile) {
		service.addStudentProfile(studentProfile);
		return studentProfile;
	}
	
	@PutMapping("/update-student-profile/{id}")
	public String updateStudentProfile(@PathVariable("id") Long id, @RequestBody StudentProfile studentProfile) {
		service.updateStudentProfile(id, studentProfile);
		return "Updated!";
	}

	@DeleteMapping("/delete-student-profile/{id}")
	public String deleteStudentProfile(@PathVariable("id") Long id) {
		service.deleteStudentProfile(id);
		return "Deleted";
	}

	@GetMapping("/test/{id}")
	public APIResponse test(@PathVariable("id") Long id) {
		return service.test(id);
	}

}
