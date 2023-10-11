package com.example.studentManager.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "average")
    private Double average;
    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> grades = new ArrayList<>();

    public Student() {
    }

    public Student(String firstName, String lastName, Double average, String email, List<Grade> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.average = average;
        this.email = email;
        this.grades = grades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getAverage() {
        average = 0.0;
        double myAverage = 0;
        double a = 0;
        for (int i = 0; i < grades.size(); i++) {
            a += grades.get(i).getGrade();
        }
        myAverage = a / grades.size();
        average = Math.round(myAverage * 100.0) / 100.0;
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
    //Le kell kezelni

    public void addGrade(Integer grade) {
        grades.add(new Grade(grade));
    }

    public void deleteGrade(Grade grade) {
        // Töröld az érdemjegyet a diák érdemjegylistájáról
        grades.remove(grade);
    }

    public void deleteGradeById(Long gradeId) {
        grades.removeIf(grade -> grade.getId().equals(gradeId));
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", average=" + average +
                ", email='" + email + '\'' +
                ", grades=" + grades +
                '}';
    }
}
