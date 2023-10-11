package com.example.studentManager.service.impl;

import com.example.studentManager.entity.Grade;
import com.example.studentManager.entity.Student;
import com.example.studentManager.repository.StudentRepository;
import com.example.studentManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    /*@Override
    public Student detailStudent(Student student) {
        return studentRepository.save(student);
    }*/

    @Override
    public void deleteGrade(Long studentId, Long gradeId) {
        Student student = studentRepository.findById(studentId).orElse(null);


        if (student != null) {
            student.deleteGradeById(gradeId);
            studentRepository.save(student);
        }
    }
}
