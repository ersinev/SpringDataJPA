package com.ersin.spring_data_jpa.services.impl;

import com.ersin.spring_data_jpa.entites.Student;
import com.ersin.spring_data_jpa.repository.StudentRepository;
import com.ersin.spring_data_jpa.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Student not found with id " + id));
    }

    @Override
    public Student updateStudentById(Long id, Student updatedStudent) {
        Optional<Student> optUpdateStudent = studentRepository.findById(id);
        if(optUpdateStudent.isPresent()){
            Student studentToUpdate = optUpdateStudent.get();
            studentToUpdate.setFirstName(updatedStudent.getFirstName());
            studentToUpdate.setLastName(updatedStudent.getLastName());
            studentToUpdate.setBirthOfDate(updatedStudent.getBirthOfDate());
            return studentRepository.save(studentToUpdate);
        }
        else {
            throw new RuntimeException("Student not found with id: " + id);
        }

    }
}
