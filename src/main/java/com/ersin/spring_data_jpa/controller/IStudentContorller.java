package com.ersin.spring_data_jpa.controller;

import com.ersin.spring_data_jpa.entites.Student;

import java.util.List;

public interface IStudentContorller {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(Long id);

    public Student updateStudentById(Long id, Student updatedStudent);

}
