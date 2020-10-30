package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Medication;
import com.revature.service.MedicationService;

@RestController("medicationController")
@RequestMapping("/medication")
public class MedicationController 
{
	private MedicationService ms;
	
	@Autowired
	public void setMedicationService(MedicationService ms)
	{
		 this.ms = ms;
	}
	
	
	@PostMapping(value="/add", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public void addMedication(@RequestBody Medication m)
	{
		ms.add(m);
	}
	
	@GetMapping(value="/all", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<Medication>> getAllMedications()
	{
		return new ResponseEntity<List<Medication>>(this.ms.getAll(), HttpStatus.OK);
	}
}
