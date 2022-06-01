package com.training.projects.Student.Department.repository;

import com.training.projects.Student.Department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department , Integer> {
}
