package com.education.dormallocation;

import com.education.dormallocation.Dao.AdminDao;
import com.education.dormallocation.Dao.DormDao;
import com.education.dormallocation.Dao.StudentDao;
import com.education.dormallocation.Entity.Administrator;
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
    AdminDao adminDao;
    @Autowired
    PasswordEncoder passwordEncoder;

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
    void encodePassword(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        String password;
        for (Long i = 1L; i <= 3500L; i++) {
            password=passwordEncoder.encode(studentDao.getPasswordById(i));
            studentDao.updateStudentPasswordById(password,i);
        }
    }

    @Test
    void encodePa(){
        Administrator administrator = new Administrator();
        String [] password = {
                "admin1",
                "admin2",
                "admin3"
        };
        int j=0;
        for (Long i = 1L; i <= 3L; i++,j++) {
            adminDao.updateAdmintPasswordById(passwordEncoder.encode(password[j]),i);
        }
    }
}
