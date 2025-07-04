package com.infybuzz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.infybuzz.entity.Student;
import com.infybuzz.feignclients.AddressFeignClient;
import com.infybuzz.repository.StudentRepository;
import com.infybuzz.request.CreateStudentRequest;
import com.infybuzz.response.AddressResponse;
import com.infybuzz.response.StudentResponse;

import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;


	@Autowired
	AddressFeignClient addressFeignClient;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());

		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);

		StudentResponse studentResponse = new StudentResponse(student);

		// studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));

		return studentResponse;
	}

	public StudentResponse getById(long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);

		// studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));

		return studentResponse;
	}

	
}
