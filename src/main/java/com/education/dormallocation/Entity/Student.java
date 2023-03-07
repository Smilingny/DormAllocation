package com.education.dormallocation.Entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String stu_id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getRest() {
        return rest;
    }

    public void setRest(Integer rest) {
        this.rest = rest;
    }

    public Integer getNeatness() {
        return neatness;
    }

    public void setNeatness(Integer neatness) {
        this.neatness = neatness;
    }

    public Integer getQuietness() {
        return quietness;
    }

    public void setQuietness(Integer quietness) {
        this.quietness = quietness;
    }

    public Integer getSmoke() {
        return smoke;
    }

    public void setSmoke(Integer smoke) {
        this.smoke = smoke;
    }

    public Integer getRhonchus() {
        return rhonchus;
    }

    public void setRhonchus(Integer rhonchus) {
        this.rhonchus = rhonchus;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }
}
