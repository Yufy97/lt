package com.zt.controller;

import com.zt.entity.Result;
import com.zt.entity.dto.GraduateLoginDto;
import com.zt.entity.dto.GraduateRegisterDto;
import com.zt.service.GraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/graduate")
public class GraduateController {
    @Autowired
    GraduateService graduateService;
    @PostMapping("/register")
    public Result register(@RequestBody GraduateRegisterDto graduateRegisterDto) {
        return graduateService.register(graduateRegisterDto);
    }

    @GetMapping("/login")
    public Result login(@RequestBody GraduateLoginDto graduateLoginDto) {
        return graduateService.login(graduateLoginDto);
    }
}
