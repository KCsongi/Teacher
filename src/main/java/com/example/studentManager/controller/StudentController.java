package com.example.studentManager.controller;

import com.example.studentManager.entity.Student;
import com.example.studentManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudent(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setAverage(student.getAverage());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/students/details/{id}")
    public String detailStudent(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);

        model.addAttribute("student", student);
        model.addAttribute("grades", student.getGrades());
        return "details_student";
    }

    @PostMapping("/students/details/{id}")
    public String updateGrade(@PathVariable Long id,
                              @ModelAttribute("student") Student student,
                              Model model) {

        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setAverage(student.getAverage());
        existingStudent.setGrades(student.getGrades());

        studentService.updateStudent(existingStudent);
        return "redirect:/students/details/" + id;
    }

    @PostMapping("/students/details/{id}/addGrade")
    public String addGradeToStudent(@PathVariable Long id, @RequestParam Integer grade) {

        Student student = studentService.getStudentById(id);

        student.addGrade(grade);
        studentService.updateStudent(student);
        System.out.println("id " + id + " grade " + grade + "..."+ student.getGrades());

        // Átirányítás az oldalra, ahol a diák részletei vannak
        return "redirect:/students/details/" + id;
    }

    /*@GetMapping("/students/details/{id}/deleteGrade")
    public String deleteGrade(@PathVariable Long id, @RequestParam Integer grade) {
        // Itt kezeld a törlési logikát
        Student student = studentService.getStudentById(id);
        List<Grade> grades = student.getGrades();

        // Ellenőrizd, hogy a törlendő érdemjegy benne van-e a listában
        if (grades.contains(grade)) {
            student.deleteGrade(grade);
            studentService.updateStudent(student); // Mentsd el a frissített diákot az adatbázisban
        }

        // Visszairányítás a részletek oldalra
        return "redirect:/students/details/" + id;
    }*/
/*    @GetMapping("/students/details/{id}/deleteGrade")
    public String deleteGrade(@PathVariable Long id, @RequestParam Integer grade) {
        Student student = studentService.getStudentById(id);
        student.deleteGrade(grade);
        studentService.updateStudent(student);
        return "redirect:/students/details/" + id;
    }*/

    @DeleteMapping("/students/details/{id}/deleteGrade")
    public String deleteGrade(@PathVariable Long id, @RequestParam Long gradeId) {
        /*Student student = studentService.getStudentById(id);
        student.deleteGrade(grade);
        studentService.updateStudent(student);
        System.out.println("id " + id + " grade " + grade);*/
        //----------------------------------
        studentService.deleteGrade(id, gradeId);
        return "redirect:/students/details/" + id;
    }
}
