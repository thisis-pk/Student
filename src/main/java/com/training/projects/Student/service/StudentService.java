package com.training.projects.Student.service;

import com.training.projects.Student.Department.entity.Department;
import com.training.projects.Student.Department.repository.DepartmentRepository;
import com.training.projects.Student.entity.Student;
import com.training.projects.Student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studRepo;

    @Autowired
    private DepartmentRepository deptRepo;



    /***** POST STUDENT *****/
    public Student addNewStudent(Student student){
        return studRepo.save(student);
    }
    /***** POST STUDENTS *****/
    public List<Student> addNewStudents(List<Student> students){
//        List<Student> stud = new ArrayList<>();
//        for(Student std : students) {
//            stud.add(std);
//        }
        return studRepo.saveAll(students);
    }



    /***** GET BY DEPT ID *****/
    public List<Student> getStudentByDeptId(int deptId){
        List<Student> students = new ArrayList<>();
        studRepo.findByDeptId(deptId)
                .forEach(students::add);
        return students;
    }



    /***** GET ALL *****/
    public List<Student> getListOfStudents(){
        return studRepo.findAll();
    }

    /***** GET STUDENTS *****/
    public List<Student> getStudents(int deptId){
        return studRepo.findAll();
    }
    /***** GET BY ID ******/
    public Student getStudent(int studId){
        return studRepo.findById(studId).get();
    }
    /***** GET BY FIRST NAME *****/
    public Student getStudentByFname(String fName){
        return studRepo.findByFirstName(fName);
    }
    /**** GET LIST OF Fname STUDENTS ****/
    public List<Student> getStudentsByFname(String fName){
        return studRepo.findAllByFirstName(fName);
    }

    /***** PUT ******/
    public Student updateStudent(int studId , Student student){
        Student existingStud = studRepo.findById(studId).get();
        existingStud.setFirstName(student.getFirstName());
        existingStud.setLastName(student.getLastName());
        existingStud.setMobileNum(student.getMobileNum());
        existingStud.setEmailId(student.getEmailId());
        existingStud.setDeptId(student.getDeptId());
        return studRepo.save(existingStud);
    }
    /***** DELETE *****/
    public String deleteStudent(int studId){
        Optional<Student> studList = studRepo.findById(studId);
        if(studList.isPresent()){
            studRepo.delete(studList.get());
            return "The student is deleted successfully !!";
        }
        else{
            throw new RuntimeException("Student not found with the ID :"+ studId);
        }
    }
}
