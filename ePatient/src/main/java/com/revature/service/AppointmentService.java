package com.revature.service;

import java.util.List;

import com.revature.dao.AppointmentDAO;
import com.revature.dao.AppointmentDAOImpl;
import com.revature.model.Appointment;
import com.revature.utility.ValidationHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "appointmentService")
public class AppointmentService {
    
    private AppointmentDAO appointmentDAO;

    @Autowired
    public void setAppointmentService(AppointmentDAOImpl appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    public boolean add(Appointment appointment){
    	if(new ValidationHelper().isValidAppointment(appointment) == false) {
    		return false;
    	}
    	
        return this.appointmentDAO.add(appointment);
    }

    public boolean update(Appointment appointment){
    	if(new ValidationHelper().isValidAppointment(appointment) == false) {
    		return false;
    	}
    	
        return this.appointmentDAO.update(appointment);
    }

    public Appointment getAppointmentByID(int id){
        return this.appointmentDAO.getAppointmentByID(id);
    }

    public List<Appointment> getAppointmentByStatus(String status){
        return this.appointmentDAO.getAppointmentByStatus(status);
    }
        
    public List<Appointment> getAll(){
        return this.appointmentDAO.getAll();
    }
}
