package com.education.dormallocation.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dormitory")
public class Dormitory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer room_number;
    private Integer building;
    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "dormitory")
    private List<Student> studentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoom_number() {
        return room_number;
    }

    public void setRoom_number(Integer room_number) {
        this.room_number = room_number;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}