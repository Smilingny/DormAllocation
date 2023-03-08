package com.education.dormallocation.Contorller;

import com.education.dormallocation.Dao.StudentDao;
import com.education.dormallocation.Entity.Student;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "学生宿舍自动分配系统")
public class StudentApi {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private Student student;

    @PostMapping(value = "login")
    @ApiOperation("学生登陆")
    @CrossOrigin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stu_id", value = "姓名", dataTypeClass = Long.class, required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataTypeClass = String.class, required = true)
    })
    @ApiResponse(code = 100, message = "成功", response = boolean.class)
    public boolean login(@RequestParam Long stu_id, @RequestParam String password) {
        student = studentDao.findStudentByStu_id(stu_id);
        return passwordEncoder.matches(password, student.getPassword());
    }
}
