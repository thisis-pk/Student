package com.training.projects.Student.repository;

import com.training.projects.Student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByFirstName(String fNamw);

    List<Student> findAllByFirstName(String fName);

    List<Student> findByDeptId(int deptId);

}
