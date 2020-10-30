package com.revature.dao;

import java.util.List;

import com.revature.model.Medication;

public interface MedicationDAO {
	
	boolean add(Medication m);
	boolean update(Medication m);
	boolean delete(Medication m);
	List<Medication> getAll();
}
