package com.revature.controller;

import java.util.List;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpSession;

import com.revature.model.Appointment;
import com.revature.model.Person;
import com.revature.service.AppointmentService;

import org.apache.commons.httpclient.HttpsURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("appointmentController")
@RequestMapping("/appointment")
@CrossOrigin
public class AppointmentController {
    private AppointmentService appointmentService;

    @Autowired
    public void setAppointmentService(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<Appointment>> getAll(){
        return new ResponseEntity<List<Appointment>>(this.appointmentService.getAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/status/{status}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<Appointment>> getAppointmentByStatus(@PathVariable String status){
        return new ResponseEntity<List<Appointment>>(this.appointmentService.getAppointmentByStatus(status),HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Appointment> getAppointmentByID(@PathVariable int id){
        return new ResponseEntity<Appointment>(this.appointmentService.getAppointmentByID(id),HttpStatus.OK);
    }

    @PostMapping(value = "/new", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Boolean> add(@RequestBody Appointment appointment){
        return new ResponseEntity<Boolean>(this.appointmentService.add(appointment),HttpStatus.OK);
    }

    @PostMapping(value = "/update", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Boolean> update(@RequestBody Appointment appointment){
        return new ResponseEntity<Boolean>(this.appointmentService.update(appointment),HttpStatus.OK);
    }
}
