package com.education.dormallocation.Contorller;

import com.education.dormallocation.Dao.StudentDao;
import com.education.dormallocation.Entity.Student;
import com.education.dormallocation.Utils.ResultData;
import io.swagger.annotations.*;
import io.swagger.models.Response;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@RestController
@Api(tags = "学生管理相关接口")
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
    @ApiResponses({
            @ApiResponse(code = 100, message = "登陆成功"),
            @ApiResponse(code = 200, message = "登陆成功")
    })
    @ApiResponse(code = 100, message = "登陆成功", response = boolean.class)
    public ResultData<Student> login(Long stu_id, String password) {

        student = studentDao.findStudentByStu_id(stu_id);
        if(passwordEncoder.matches(password,student.getPassword())) {
            return ResultData.success(student);
        }
        return ResultData.fail(1002,"用户名或密码错误");
    }

    @PostMapping(value = "requirement")
    @ApiOperation("住宿要求")
    @CrossOrigin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stu_id", value = "学号", dataTypeClass = Long.class, required = true),
            @ApiImplicitParam(name = "neatness", value = "卫生", dataTypeClass = Integer.class, required = true),
            @ApiImplicitParam(name = "quietness", value = "安静", dataTypeClass = Integer.class, required = true),
            @ApiImplicitParam(name = "smoke", value = "吸烟", dataTypeClass = Integer.class, required = true),
            @ApiImplicitParam(name = "rest", value = "作息", dataTypeClass = Integer.class, required = true),
            @ApiImplicitParam(name = "rhonchus", value = "打呼", dataTypeClass = Integer.class, required = true),
    })
    public ResultData<Student> requirement(Long stu_id, Integer neatness,
                            Integer quietness, Integer smoke,
                            Integer rest, Integer rhonchus) {
        student = studentDao.findStudentByStu_id(stu_id);
        student.setNeatness(neatness);
        student.setQuietness(quietness);
        student.setSmoke(smoke);
        student.setRest(rest);
        student.setRhonchus(rhonchus);
        return ResultData.success(studentDao.save(student));
    }

    @PostMapping(value = "password")
    @ApiOperation("密码修改")
    @CrossOrigin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stu_id", value = "学号", dataTypeClass = Long.class, required = true),
            @ApiImplicitParam(name = "oldPassword",value = "旧密码",dataTypeClass = String.class,required = true),
            @ApiImplicitParam(name = "newPassword",value = "新密码",dataTypeClass = String.class,required = true)
    })
    public ResultData<Student> changePassword(@RequestParam Long stu_id, @RequestParam String oldPassword, @RequestParam String newPassword){
        student = studentDao.findStudentByStu_id(stu_id);
        System.out.println(student.getName());
        if(passwordEncoder.matches(oldPassword,studentDao.getPasswordByStu_id(stu_id))) {
            if(studentDao.updateStudentPasswordByStu_id(passwordEncoder.encode(newPassword), stu_id) == 1){
                return ResultData.success(null);
            }
        }
        return ResultData.fail(999,"修改失败");
    }
}
