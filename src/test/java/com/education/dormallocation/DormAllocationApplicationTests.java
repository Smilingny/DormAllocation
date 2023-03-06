package com.education.dormallocation;

import com.education.dormallocation.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class DormAllocationApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
        Long aL = jdbcTemplate.queryForObject("select count(*) from student",Long.class);
        System.out.println("test OracleConnect : {} 条"+aL);
    }

}
