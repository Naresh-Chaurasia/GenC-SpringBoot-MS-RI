package com.infybuzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infybuzz.request.CreateStudentRequest;
import com.infybuzz.response.StudentResponse;
import com.infybuzz.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello from Student Service!";
	}

	@PostMapping("/create")
	public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
		return studentService.createStudent(createStudentRequest);
	}

	@GetMapping("getById/{id}")
	public StudentResponse getById(@PathVariable long id) {
		return studentService.getById(id);
	}

	@GetMapping("/getAll")
	public List<StudentResponse> getAll() {
		return studentService.getAll();
	}

}
