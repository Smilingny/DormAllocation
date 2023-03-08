package com.education.dormallocation.Contorller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "学生宿舍自动分配系统")
public class StudentApi {
    @GetMapping("/he")
    public String  hello(){
        return "你好，世界";
    }
}
