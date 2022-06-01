package com.training.projects.Student.Department.service;


import com.training.projects.Student.Department.entity.Department;
import com.training.projects.Student.Department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository deptRepo;

    /*** POST ***/
    public Department addNewDepartment(Department department){
        return deptRepo.save(department);
    }

    /*** GET BY STUDENTID ***/


    /*** GET ***/
    public List<Department> getDepartmentList(){
        return deptRepo.findAll();
    }

    /*** GET BY ID ***/
    public Department getDepartment(int deptId){
        return deptRepo.findById(deptId).get();
    }


}
