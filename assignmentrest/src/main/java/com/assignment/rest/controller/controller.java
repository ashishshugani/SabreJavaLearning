package com.assignment.rest.controller;

import com.assignment.rest.Student;
import com.assignment.rest.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/")
public class controller {

    @Autowired
    service serviceObj;

    @RequestMapping(method = RequestMethod.POST, value = "/inputMessage", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Student[] unmatch(@RequestBody Student[] info){

        Student result[] = serviceObj.modification(info);

        return result;

    }
}
