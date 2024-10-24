package com.ersin.spring_data_jpa.controller.impl;

import com.ersin.spring_data_jpa.controller.IStudentContorller;
import com.ersin.spring_data_jpa.entites.Student;
import com.ersin.spring_data_jpa.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(path = "/list")
    @Override
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/{id}")
    @Override
    public Student getStudentById(@PathVariable(name = "id") Long id) {
        return studentService.getStudentById(id);
    }
    @PutMapping(path = "/update/{id}")
    @Override
    public Student updateStudentById(@PathVariable(name = "id") Long id, @RequestBody Student updatedStudent) {
        return studentService.updateStudentById(id, updatedStudent);
    }



}
