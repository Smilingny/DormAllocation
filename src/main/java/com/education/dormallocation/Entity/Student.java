package com.education.dormallocation.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long stu_id;
    @JsonIgnore
    private String password;
    private String name;
    private Boolean sex;
    // 作息
    private Integer rest;
    // 卫生
    private Integer neatness;
    // 安静
    private Integer quietness;
    // 抽烟
    private Integer smoke;
    // 鼾声
    private Integer rhonchus;
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private Dormitory dormitory;
}
