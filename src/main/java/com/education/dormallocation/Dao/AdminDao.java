package com.education.dormallocation.Dao;

import com.education.dormallocation.Entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Administrator, Long> {

}
