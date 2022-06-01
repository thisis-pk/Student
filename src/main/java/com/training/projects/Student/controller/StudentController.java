package com.training.projects.Student.controller;

import com.training.projects.Student.entity.Student;
import com.training.projects.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*** POST REQUEST ***/
    @PostMapping("/addNewStudent")
    public Student addNewStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }
   /*** POST MULTIPLE STUDENTS ***/
   @PostMapping("/addListOfStudents")
   public List<Student> addNewStudents(@RequestBody List<Student> students){
        return studentService.addNewStudents(students);
   }

   /*** GET ALL ***/
   @GetMapping(value = "/getAllStudents")
   public List<Student> getListOfStudents(){
       return studentService.getListOfStudents();
   }


   /*** GET REQUEST BY DEPT ID ***/
   @GetMapping(value = "/getStudent/byDepartment/{deptId}")
   public List<Student> getStudentByDeptById(@PathVariable int deptId){
        return studentService.getStudentByDeptId(deptId);
   }


    /*** GET REQUEST ***/
    @GetMapping("/department/{deptId}/getStudents")
    public List<Student> getStudents(@PathVariable int deptId){
        return studentService.getStudents(deptId);
    }

    /*** GET REQUEST WITH PATH VARIABLE ***/
    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable("id") int studId){
        return studentService.getStudent(studId);
    }
    /*** GET BY FIRST NAME ***/
    @GetMapping("/getStudent/firstName/{fName}")
    public Student getStudentByFname(@PathVariable String fName){
        return studentService.getStudentByFname(fName);
    }
    /*** GET LIST OF STUDENTS WITH SAME NAME ***/
    @GetMapping("/getStudentsList/firstName/{fName}")
    public List<Student> getStudentsByFname(@PathVariable String fName){
        return studentService.getStudentsByFname(fName);
    }

    /*** PUT REQUEST ***/
    @PutMapping("/updateStudent/{studId}")
    public Student updateStudent(@PathVariable int studId, @RequestBody Student student){
        return studentService.updateStudent(studId, student);
    }
    /*** DELETE REQUEST ***/
    @DeleteMapping("/deleteStudent/{studId}")
    public String deleteStudent(@PathVariable int studId){
        return studentService.deleteStudent(studId);
    }
}
