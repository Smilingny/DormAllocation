package com.education.dormallocation.Contorller;

import com.education.dormallocation.Dao.StudentDao;
import com.education.dormallocation.Entity.Student;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
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
            @ApiImplicitParam(name = "stu_id", value = "学号", dataTypeClass = Long.class, required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataTypeClass = String.class, required = true)
    })
    @ApiResponse(code = 100, message = "成功", response = boolean.class)
    public boolean login(@RequestParam Long stu_id, @RequestParam String password) {
        student = studentDao.findStudentByStu_id(stu_id);
        return passwordEncoder.matches(password, student.getPassword());
    }

    @PostMapping(value = "requirement")
    @ApiOperation("住宿要求")
    @CrossOrigin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stu_id",value = "学号",dataTypeClass = Long.class,required = true),
            @ApiImplicitParam(name = "neatness", value = "卫生", dataTypeClass = Integer.class, required = true),
            @ApiImplicitParam(name = "quietness", value = "安静", dataTypeClass = Integer.class, required = true),
            @ApiImplicitParam(name = "smoke", value = "吸烟", dataTypeClass = Integer.class, required = true),
            @ApiImplicitParam(name = "rest", value = "作息", dataTypeClass = Integer.class, required = true),
            @ApiImplicitParam(name = "rhonchus", value = "打呼", dataTypeClass = Integer.class, required = true),
    })
    @ApiResponse(code = 100, message = "成功", response = boolean.class)
    public void requirement(@RequestParam Long stu_id,@RequestParam Integer neatness,
                               @RequestParam Integer quietness, @RequestParam Integer smoke,
                               @RequestParam Integer rest, @RequestParam Integer rhonchus) {
        student = studentDao.findStudentByStu_id(stu_id);
        student.setNeatness(neatness);
        student.setQuietness(quietness);
        student.setSmoke(smoke);
        student.setRest(rest);
        student.setRhonchus(rhonchus);
        studentDao.save(student);
    }
}
