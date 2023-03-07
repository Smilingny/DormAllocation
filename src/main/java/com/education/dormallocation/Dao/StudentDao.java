package com.education.dormallocation.Dao;

import com.education.dormallocation.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Long> {
    Student findStudentById(Long id);

    Student findStudentByName(String name);

    List<Student> findAll();

    @Transactional
    @Modifying
    void deleteStudentById(Long id);

    @Transactional
    @Modifying
    @Query("update Student s set s.password=?1 where s.id=?2")
    void updateStudentPasswordByStu_id(String password, Long stu_id);
}
