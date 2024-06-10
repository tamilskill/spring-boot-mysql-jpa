package com.tamilskillhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamilskillhub.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
