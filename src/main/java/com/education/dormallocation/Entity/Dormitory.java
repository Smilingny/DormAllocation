package com.education.dormallocation.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "dormitory")
public class Dormitory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer room_number;
    private Integer lived_stu;
    private Integer building;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "dormitory",fetch = FetchType.EAGER)
    private List<Student> studentList;

}
