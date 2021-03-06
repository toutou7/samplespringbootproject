package com.example.studentservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.studentservice.model.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentservice.model.StudentProfile;
import com.example.studentservice.repositories.StudentProfileRepository;
import com.example.studentservice.service.StudentProfileService;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {
	
	@Autowired
	private StudentProfileRepository repo;
	
	@Override
	public List<StudentProfile> findAll(){
		return repo.findAll();
	}
	
	@Override 
	public Optional<StudentProfile> findById(Long id){
		return repo.findById(id);
	}

	@Override
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

		repo.save(studentProfile);
		return "Default profile has been added";
	}


	@Override
	public void addStudentProfile(StudentProfile studentProfile) {
		repo.save(studentProfile);
	}

	@Override
	public void updateStudentProfile(Long id, StudentProfile request) {
		StudentProfile studentProfile = repo.getById(id);
		studentProfile.setFirstName(request.getFirstName());
		studentProfile.setLastName(request.getLastName());
		studentProfile.setPhoneNumber(request.getPhoneNumber());
		studentProfile.setEmail(request.getEmail());
		repo.save(studentProfile);
	}

	@Override
	public void deleteStudentProfile(Long id) {
		repo.deleteById(id);
	}

	@Override
	public APIResponse test(Long id) {
		APIResponse response = new APIResponse();
		response.setStudentProfile(repo.findById(id));
		String code = (repo.findById(id).isPresent()) ? "Found user with ID=" + Long.toString(id)
				: "Cannot find user with ID=" + Long.toString(id);
		response.setCode(code);
		return response;
	}
}
