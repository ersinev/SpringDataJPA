package com.ersin.spring_data_jpa.services;

import com.ersin.spring_data_jpa.dto.DtoStudent;
import com.ersin.spring_data_jpa.dto.DtoStudentIU;
import com.ersin.spring_data_jpa.entites.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU student);
    public List<DtoStudent> getAllStudents();
    public DtoStudent getStudentById(Long id);

    public DtoStudent updateStudentById(Long id, DtoStudentIU updatedStudentIU);

    public ResponseEntity<String> deleteStudentById(Long id);

}
