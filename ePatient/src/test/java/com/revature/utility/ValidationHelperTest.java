package com.revature.utility;

import java.sql.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.model.Appointment;
import com.revature.model.Medication;
import com.revature.model.Person;

public class ValidationHelperTest {

	public static ValidationHelper vh;

	@BeforeClass
	public static void beforeClass() {
		vh = new ValidationHelper();
	}

	@Test
	public void testIsValidName() {
		Assert.assertTrue(vh.isValidName("vzxcvzcv"));
		Assert.assertTrue(vh.isValidName("asdf weA FHGFGK"));
		Assert.assertTrue(vh.isValidName("a          "));
		Assert.assertFalse(vh.isValidName("32asf312sfadf"));
		Assert.assertFalse(vh.isValidName("   "));
	}

	@Test
	public void testIsValidStatus() {
		Assert.assertTrue(vh.isValidStatus("vzxcvzcv"));
		Assert.assertTrue(vh.isValidStatus("asdf weA FHGFGK"));
		Assert.assertTrue(vh.isValidStatus("a          "));
		Assert.assertFalse(vh.isValidStatus("32asf312sfadf"));
		Assert.assertFalse(vh.isValidStatus("   "));
	}

	@Test
	public void testContainSpaces() {
		Assert.assertTrue(vh.containSpaces("test space"));
		Assert.assertFalse(vh.containSpaces("Testnospace"));
	}

	@Test
	public void testIsInt() {
		Assert.assertTrue(vh.isInt("23"));
		Assert.assertFalse(vh.isInt("23.3"));
		Assert.assertFalse(vh.isInt("not int"));
		Assert.assertFalse(vh.isInt(""));
		Assert.assertFalse(vh.isInt(null));
	}

	@Test
	public void testIsDouble() {
		Assert.assertTrue(vh.isDouble("23"));
		Assert.assertTrue(vh.isDouble("23.26"));
		Assert.assertFalse(vh.isDouble("not int"));
		Assert.assertFalse(vh.isDouble(""));
		Assert.assertFalse(vh.isDouble(null));
	}

	@Test
	public void testIsValidAppointment() {
		Assert.assertFalse(vh.isValidAppointment(new Appointment()));
		Assert.assertTrue(vh
				.isValidAppointment(new Appointment(1, new Person(), new Person(), new Date(2135465), "lol", "help")));
	}

	@Test
	public void testIsValidMedication() {
		Assert.assertFalse(vh.isValidMedication(new Medication()));
		Assert.assertTrue(vh.isValidMedication(new Medication(1, "as asfFSD dfasdf", "werGKFSGGS", 54)));
	}
}
