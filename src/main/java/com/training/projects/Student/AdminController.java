package com.training.projects.Student;


import com.training.projects.Student.AdminService;
import com.training.projects.Student.dto.StudentDepartmentDTO;
import com.training.projects.Student.entity.Student;
import com.training.projects.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Student/Department")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**** POST ****/
    @PostMapping(value = "/addNew/StudDept")
    public StudentDepartmentDTO addStudDept(@RequestBody StudentDepartmentDTO studentDepartmentDTO){
        return adminService.addStudDept(studentDepartmentDTO);
    }

    /**** GET ****/
    @GetMapping(value = "/getStudentDepartment/{studId}")
    public StudentDepartmentDTO getStudDeptDetails(@PathVariable Integer studId){
        return adminService.getStudDeptDetails(studId);
    }

    /*** GET ***/
    @GetMapping(value = "/getListOfStudents/department/{deptId}")
    public StudentDepartmentDTO getStudentListsInDept(@PathVariable int deptId){
        return adminService.getStudentListsInDept(deptId);
    }
}
