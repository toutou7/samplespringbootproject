package com.example.studentservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("phone_number")
	private String phoneNumber;

	@Column(unique=true)
	private String email;

	//PR is Pull Request. How do I do that, huh?

}
