package com.infybuzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infybuzz.request.CreateAddressRequest;
import com.infybuzz.response.AddressResponse;
import com.infybuzz.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping("/create")
	public AddressResponse createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
		return addressService.createAddress(createAddressRequest);
	}

	@GetMapping("/getById/{id}")
	public AddressResponse getById(@PathVariable long id) {
		return addressService.getById(id);
	}

	@GetMapping("/getAll")
	public List<AddressResponse> getAll() {
		return addressService.getAll();
	}

}
