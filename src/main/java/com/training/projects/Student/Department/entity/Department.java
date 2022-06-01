package com.training.projects.Student.Department.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department_db")
public class Department implements Serializable {

    @Id
    @Column(name = "dept_id")
    private int deptId;
    private String course;
    @Column(name = "course_duration")
    private String courseDur;
}
