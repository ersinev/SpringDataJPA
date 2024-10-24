package com.ersin.spring_data_jpa.controller.impl;

import com.ersin.spring_data_jpa.controller.IStudentContorller;
import com.ersin.spring_data_jpa.entites.Student;
import com.ersin.spring_data_jpa.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/student")

public class StudentControllerImpl implements IStudentContorller {

    @Autowired
    private IStudentService studentService;
    @PostMapping(path = "/save")
    @Override
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}
