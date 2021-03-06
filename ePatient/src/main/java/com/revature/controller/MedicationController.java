package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Medication;
import com.revature.service.MedicationService;

@RestController("medicationController")
@RequestMapping("/medication")
@CrossOrigin
public class MedicationController {
	private MedicationService ms;

	@Autowired
	public void setMedicationService(MedicationService ms) {
		this.ms = ms;
	}

	@PostMapping(value = "/add", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<Boolean> addMedication(@RequestBody Medication m) {
		return new ResponseEntity<Boolean>(this.ms.add(m), HttpStatus.OK);
	}

	@GetMapping(value = "/all", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<Medication>> getAllMedications() {
		return new ResponseEntity<List<Medication>>(this.ms.getAll(), HttpStatus.OK);
	}

	@PostMapping(value = "/update", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<Boolean> updateMedication(@RequestBody Medication m) {
		return new ResponseEntity<Boolean>(this.ms.update(m), HttpStatus.OK);
	}

	@GetMapping(value = "/get/{id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<Medication> getMedicationById(@PathVariable int id) {
		return new ResponseEntity<Medication>(this.ms.getMedicationById(id), HttpStatus.OK);
	}
}
