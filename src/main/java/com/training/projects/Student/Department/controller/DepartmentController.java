package com.training.projects.Student.Department.controller;

import com.training.projects.Student.Department.entity.Department;
import com.training.projects.Student.Department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Department")
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService deptService;

    /***** POST *****/
    @PostMapping("/add/NewDepartment")
    public Department addNewDepartment(@RequestBody Department department){
        return deptService.addNewDepartment(department);
    }
    /***** GET ****/
    @GetMapping("/getAllDepartments")
    public List<Department> getListOfDepartments(){
        return deptService.getDepartmentList();
    }
    /**** GET BY ID ****/
    @GetMapping
    public Department getDepartment(@PathVariable int deptId){
        return deptService.getDepartment(deptId);
    }

}
