package com.ersin.spring_data_jpa.controller.impl;

import com.ersin.spring_data_jpa.controller.IStudentContorller;
import com.ersin.spring_data_jpa.dto.DtoStudent;
import com.ersin.spring_data_jpa.dto.DtoStudentIU;
import com.ersin.spring_data_jpa.entites.Student;
import com.ersin.spring_data_jpa.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")

public class StudentControllerImpl implements IStudentContorller {

    @Autowired
    private IStudentService studentService;
    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU student) {
        return studentService.saveStudent(student);
    }
    @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable(name = "id") Long id) {
        return studentService.getStudentById(id);
    }
    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudentById(@PathVariable(name = "id") Long id, @RequestBody DtoStudentIU updatedStudentIU) {
        return studentService.updateStudentById(id, updatedStudentIU);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public ResponseEntity<String> deleteStudentById(@PathVariable(name = "id")Long id){
        return studentService.deleteStudentById(id);
    }


}
