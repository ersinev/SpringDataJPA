package com.ersin.spring_data_jpa.repository;

import com.ersin.spring_data_jpa.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "select * from student.student", nativeQuery = true)
    List<Student> findAllStudents();

    @Query(value = "from Student s WHERE s.id= :studentId")
    Optional<Student> findStudentById(Long studentId);
}
