package com.training.projects.Student;

import com.training.projects.Student.Department.entity.Department;
import com.training.projects.Student.Department.repository.DepartmentRepository;
import com.training.projects.Student.dto.StudentDepartmentDTO;
import com.training.projects.Student.entity.Student;
import com.training.projects.Student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private StudentRepository studRepo;

    @Autowired
    private DepartmentRepository deptRepo;

    /*** POST METHOD ***/
    public StudentDepartmentDTO addStudDept(StudentDepartmentDTO studentDepartmentDTO) {
        StudentDepartmentDTO studDeptDTO = new StudentDepartmentDTO();
        Student student = studRepo.save(studentDepartmentDTO.getStudent().get(0));
        studDeptDTO.getStudent().add(student);
        Department department = deptRepo.save(studentDepartmentDTO.getDepartment());
        studDeptDTO.setDepartment(department);
        return studDeptDTO;
    }

    /*** GET DEPT DETAIL BY STUD ID ***/
    public StudentDepartmentDTO getStudDeptDetails(int studId){
        StudentDepartmentDTO studDeptDTO = new StudentDepartmentDTO();
        Optional<Student> student = studRepo.findById(studId);
        if (student.isPresent()){
            ArrayList<Student> students = new ArrayList<>();
            students.add(student.get());
            studDeptDTO.setStudent(students);
            try {
                Optional<Department> department = deptRepo.findById(studDeptDTO.getStudent().get(0).getDeptId());
                studDeptDTO.setDepartment(department.get());
                return studDeptDTO;
            }catch (NullPointerException npe){
                System.out.println("null");
            }
        }
        return studDeptDTO;
    }

    /*** GET STUDENT LIST BY DEPT ID ***/
    public StudentDepartmentDTO getStudentListsInDept(int deptId){
        StudentDepartmentDTO studDeptDTO = new StudentDepartmentDTO();
///        List<StudentDepartmentDTO> studDeptDTOSList = new ArrayList<>();
        Optional<Department> department = deptRepo.findById(deptId);
        if (department.isPresent()){
            studDeptDTO.setDepartment(department.get());
            List<Student> students = studRepo.findByDeptId(studDeptDTO.getDepartment().getDeptId());
            studDeptDTO.setStudent(students);

        }
        return studDeptDTO;
    }

}
