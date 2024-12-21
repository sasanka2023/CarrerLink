package com.example.CarrerLink_backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Technologies")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TechId;

    private String TechName;

    @ManyToMany(mappedBy = "technologies")
    private List<Job> jobs;

    @ManyToMany(mappedBy = "technologies")
    private List<Student> students;

}
