package com.infybuzz.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infybuzz.response.AddressResponse;

//Without Eureka
// address.service.url=http://localhost:8082/api/address/getById/1
// @FeignClient(url = "${address.service.url}", value = "address-feign-client",path = "/api/address")
//Declarative Way to call api

//192.168.1.36:address-service2:8082
//With Eureka
@FeignClient(value = "address-service2", path = "/api/address")
public interface AddressFeignClient {

	@GetMapping("/getById/{id}")
	public AddressResponse getById(@PathVariable long id);

}
