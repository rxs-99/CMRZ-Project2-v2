package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Prescription;
import com.revature.service.PrescriptionService;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController 
{
	private PrescriptionService ps;
	
	@Autowired
	public void setPrescriptionService(PrescriptionService ps)
	{
		 this.ps = ps;
	}
	
	@PostMapping(value="/add", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public void addPrescription(@RequestBody Prescription p)
	{
		ps.add(p);
	}
	
	@GetMapping(value="/all", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<Prescription>> getAllPrescriptions()
	{
		return new ResponseEntity<List<Prescription>>(this.ps.getAll(), HttpStatus.OK);
	}
	
}
