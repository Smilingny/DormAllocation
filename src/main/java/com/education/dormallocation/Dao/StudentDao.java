package com.education.dormallocation.Dao;

import com.education.dormallocation.Entity.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Long> {
    @Query("select  s from Student s where s.stu_id = ?1")
    Student findStudentByStu_id(Long stu_id);


    Student findStudentByName(String name);

    @Query("select password from Student where id=?1")
    String getPasswordById(Long id);

    @Query("select password from Student where stu_id=?1")
    String getPasswordByStu_id(Long stu_id);

    List<Student> findAll();

    @Transactional
    @Modifying
    void deleteStudentById(Long id);

    @Transactional
    @Modifying
    @Query("update Student s set s.password=?1 where s.stu_id=?2")
    Integer updateStudentPasswordByStu_id(String password, Long stu_id);

    @Transactional
    @Modifying
    @Query("update Student s set s.password=?1 where s.id=?2")
    Integer updateStudentPasswordById(String password, Long id);
}
