package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.service.MetaDataService;

@RestController
@CrossOrigin
public class MetaDataController {
	
	@Autowired
	MetaDataService service;
	
	@GetMapping(value = "/metadata")
	public Object getMetaData() {
		return service.getMetadata();
	}
	
	@GetMapping(value = "/metadata/{id}")
	public Object getMetaDataWithId(@PathVariable String id) {
		return service.getMetadataWithId(id);
	}
	
	@PostMapping(value = "/metadata")
	public Object addMetadata(@RequestBody Object data) {
		return service.postMetadata(data);
	}
	

	@DeleteMapping(value = "/metadata/{id}")
	public Object deleteMetaDataWithId(@PathVariable String id) {
		return service.deleteMetadataWithId(id);
	}

}
