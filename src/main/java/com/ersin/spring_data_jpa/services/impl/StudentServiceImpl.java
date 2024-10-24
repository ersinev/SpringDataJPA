package com.ersin.spring_data_jpa.services.impl;

import com.ersin.spring_data_jpa.entites.Student;
import com.ersin.spring_data_jpa.repository.StudentRepository;
import com.ersin.spring_data_jpa.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);

    }
}
