package com.revature.utility;

import com.revature.model.Appointment;
import com.revature.model.Medication;

public class ValidationHelper {

	public ValidationHelper() {

	}

	public boolean isValidName(String input) {
		return input.matches("^[a-zA-Z][a-zA-Z\\s]*$");
	}

	public boolean isValidStatus(String status) {
		return status.matches("^[a-zA-Z][a-zA-Z\\s]*$");
	}

	public boolean containSpaces(String input) {

		if (input.contains(" "))
			return true;

		return false;
	}

	public boolean isInt(String input) {
		try {
			int value = Integer.valueOf(input);
		} catch (Exception e) {
			System.out.println("Not an integer!");
			return false;
		}

		return true;
	}

	public boolean isDouble(String input) {
		try {
			double value = Double.valueOf(input);
		} catch (Exception e) {
			System.out.println("Not a double!");
			return false;
		}

		return true;
	}

	public boolean isValidAppointment(Appointment appointment) {

		if (appointment.getDate() == null)
			return false;
		else if (appointment.getPatient() == null)
			return false;
		else if (appointment.getStatus() == null)
			return false;
		else if (appointment.getDoctor() == null)
			return false;

		return true;
	}

	public boolean isValidMedication(Medication medication) {
		if (medication.getName() == null || medication.getName().equals("") || !this.isValidName(medication.getName()))
			return false;
		else if (medication.getSupplier() == null || medication.getSupplier().equals("")
				|| !this.isValidName(medication.getSupplier()))
			return false;
		else if (medication.getAmountStored() < 0)
			return false;
		return true;
	}
}
