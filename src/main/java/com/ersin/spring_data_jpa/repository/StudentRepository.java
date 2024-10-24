package com.ersin.spring_data_jpa.repository;

import com.ersin.spring_data_jpa.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
