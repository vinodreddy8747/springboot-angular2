package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/dataset")
public class DataSetController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/id")
	public ResponseEntity<String> getDataSetId(){
		MultiValueMap<String, String> headers = null;
		HttpEntity<String> entity = new HttpEntity<>(headers);
		return restTemplate.exchange("http://api.coxauto-interview.com/api/datasetId", HttpMethod.GET, entity, String.class);
	}
}
