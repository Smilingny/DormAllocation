package com.education.dormallocation.Dao;

import com.education.dormallocation.Entity.Dormitory;
import com.education.dormallocation.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DormDao extends JpaRepository<Dormitory, Long> {
    Dormitory getDormitoriesById(Long id);
}
