package com.infybuzz.service;

import java.util.stream.Collectors;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infybuzz.entity.Address;
import com.infybuzz.repository.AddressRepository;
import com.infybuzz.request.CreateAddressRequest;
import com.infybuzz.response.AddressResponse;

@Service
public class AddressService {

	Logger logger = LoggerFactory.getLogger(AddressService.class);

	@Autowired
	AddressRepository addressRepository;

	public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {

		Address address = new Address();
		address.setStreet(createAddressRequest.getStreet());
		address.setCity(createAddressRequest.getCity());

		addressRepository.save(address);

		return new AddressResponse(address);

	}

	public AddressResponse getById(long id) {

		logger.info("Inside getById " + id);

		Address address = addressRepository.findById(id).get();

		return new AddressResponse(address);
	}

	public List<AddressResponse> getAll() {
		List<Address> addresses = addressRepository.findAll();
		return addresses.stream()
				.map(AddressResponse::new)
				.collect(Collectors.toList());
	}

}
