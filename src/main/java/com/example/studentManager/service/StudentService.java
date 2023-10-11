package com.example.studentManager.service;

import com.example.studentManager.entity.Grade;
import com.example.studentManager.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

    //Student detailStudent(Student student);

    void deleteGrade(Long studentId, Long gradeId);
}
