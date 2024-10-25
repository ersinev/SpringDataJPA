package com.ersin.spring_data_jpa.services.impl;

import com.ersin.spring_data_jpa.dto.DtoStudent;
import com.ersin.spring_data_jpa.dto.DtoStudentIU;
import com.ersin.spring_data_jpa.entites.Student;
import com.ersin.spring_data_jpa.repository.StudentRepository;
import com.ersin.spring_data_jpa.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    //Save student ------------------------------------------------------------------
    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudent) {
        Student student = new Student();
        DtoStudent response = new DtoStudent();
        BeanUtils.copyProperties(dtoStudent, student);
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent,response);
        return response;

    }
    //GET All Students------------------------------------------------------------------
    @Override
    public List<DtoStudent> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<DtoStudent> dtoStudents = new ArrayList<>();

        for(Student student: students){
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student,dtoStudent);
            dtoStudents.add(dtoStudent);
        }

        return dtoStudents;



    }
    //GET By ID------------------------------------------------------------------
    @Override
    public DtoStudent getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student.get(),dtoStudent);
            return dtoStudent;
        }else{
            throw new RuntimeException("Student with id " +id+ " not found");
        }

    }




    //UPDATE By ID ------------------------------------------------------------------
    @Override
    public DtoStudent updateStudentById(Long id, DtoStudentIU updatedStudentIU) {
        Optional<Student> optUpdateStudent = studentRepository.findById(id);
        if (optUpdateStudent.isPresent()){
            Student studentToUpdate = optUpdateStudent.get();

            BeanUtils.copyProperties(updatedStudentIU, studentToUpdate, "id");
            Student updatedStudent = studentRepository.save(studentToUpdate);
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(updatedStudent,dtoStudent);
            return dtoStudent;


        }else{
            throw new RuntimeException("Student not found with id: " + id);
        }


    }




    //DELETE By ID ------------------------------------------------------------------
    @Override
    public ResponseEntity<String> deleteStudentById(Long id){
        Optional<Student> optDeleteStudent = studentRepository.findById(id);
        if(optDeleteStudent.isPresent()){
            Student studentToDelete = optDeleteStudent.get();
            studentRepository.delete(studentToDelete);
            return ResponseEntity.ok("Student with id " + id + " deleted successfully");
        }else{
            return ResponseEntity.status(404).body("Student not found with id: " + id);
        }

    }
}
