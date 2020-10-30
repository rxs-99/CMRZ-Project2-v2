package com.revature.controller;

import java.util.List;

import com.revature.model.Appointment;
import com.revature.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("appointmentController")
@RequestMapping("/appointment")
public class AppointmentController {
    private AppointmentService appointmentService;

    @Autowired
    public void setAppointmentService(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public ResponseEntity<List<Appointment>> getAll(){
        return new ResponseEntity<List<Appointment>>(this.appointmentService.getAll(),HttpStatus.OK);
    }
}
