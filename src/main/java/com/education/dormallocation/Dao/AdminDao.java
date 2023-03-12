package com.education.dormallocation.Dao;

import com.education.dormallocation.Entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AdminDao extends JpaRepository<Administrator, Long> {
    @Transactional
    @Modifying
    @Query("update Administrator ad set ad.password=?1 where ad.id=?2")
    void updateAdmintPasswordById(String password, Long id);
}
