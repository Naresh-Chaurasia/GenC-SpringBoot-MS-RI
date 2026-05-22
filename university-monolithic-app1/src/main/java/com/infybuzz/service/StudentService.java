package com.infybuzz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infybuzz.entity.Address;
import com.infybuzz.entity.Student;
import com.infybuzz.repository.AddressRepository;
import com.infybuzz.repository.StudentRepository;
import com.infybuzz.request.CreateStudentRequest;
import com.infybuzz.response.StudentResponse;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AddressRepository addressRepository;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Address address = new Address();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());

		address = addressRepository.save(address);

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());

		student.setAddress(address);
		student = studentRepository.save(student);

		return new StudentResponse(student);
	}

	public StudentResponse getById(long id) {
		return new StudentResponse(studentRepository.findById(id).get());
	}

	public List<StudentResponse> getAll() {
		List<Student> students = studentRepository.findAll();
		return students.stream()
				.map(StudentResponse::new)
				.collect(Collectors.toList());
	}
}
