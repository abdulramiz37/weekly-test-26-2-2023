<<<<<<< HEAD
package com.example.studentPortal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "course_tbl")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String title;
    private String description;
    private String duration;

    @ManyToMany
    List<Student> students = new ArrayList<>();
}
=======
package com.example.studentPortal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "course_tbl")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Id;
    private String title;
    private String description;
    private String duration;

    @ManyToMany
    List<Student> students = new ArrayList<>();
}
>>>>>>> b8a4edad8d92aee6c0691373c4ff47bb81246d5f
