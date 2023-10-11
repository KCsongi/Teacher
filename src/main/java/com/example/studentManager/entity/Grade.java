package com.example.studentManager.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer grade;

    public Grade() {
    }

    public Grade(Integer grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade=" + grade +
                '}';
    }
}
