package com.education.dormallocation;

import com.education.dormallocation.Dao.DormDao;
import com.education.dormallocation.Dao.StudentDao;
import com.education.dormallocation.Entity.Dormitory;
import com.education.dormallocation.Entity.Student;
import com.education.dormallocation.Utils.Encode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestExecutionListeners;

import javax.lang.model.util.SimpleTypeVisitor6;
import java.util.List;

@SpringBootTest
class DormAllocationApplicationTests {

    @Autowired
    StudentDao studentDao;
    @Autowired
    DormDao dormDao;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    void contextLoads() {
       Student student = new Student();
        student.setName("小明");
        student.setRest(4);
        student.setQuietness(3);
        student.setNeatness(3);
        student.setSmoke(2);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        String password = passwordEncoder.encode("qwdgueyfvu");
        student.setPassword(password);
        student.setStu_id(20211060111L);
        studentDao.save(student);
    }

    @Test
    void aaaa(){
        Student student = new Student();
        student = studentDao.findStudentByStu_id(2021100036L);
        System.out.println(student.getName());
    }
    @Test
    void Students_in_dorm(){
        Dormitory dormitory = new Dormitory();
        dormitory = dormDao.getDormitoriesById(1L);
        List<Student> studentList = dormitory.getStudentList();
        for (Student s : studentList) {
            System.out.println(s.getName());
        }
    }
    @Test
    void compare(){
        String str="sdfsefesfss";
        String password = passwordEncoder.encode(str);
        String s=passwordEncoder.encode(str);
        if (password.equals(s)) {
            System.out.println("密码匹配");
        } else {
            System.out.println("密码不匹配");
        }
    }

    @Test
    void encodePassword(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        String password;
        for (Long i = 1L; i <= 3500L; i++) {
            password=passwordEncoder.encode(studentDao.getPasswordById(i));
            studentDao.updateStudentPasswordById(password,i);
        }
    }
}
