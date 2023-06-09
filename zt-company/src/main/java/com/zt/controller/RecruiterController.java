package com.zt.controller;

import com.zt.entity.Result;
import com.zt.entity.dto.RecruiterInfoDto;
import com.zt.entity.dto.RecruiterLoginDto;
import com.zt.entity.dto.RecruiterRegisterDto;
import com.zt.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {
    @Autowired
    RecruiterService recruiterService;
    @PostMapping("/register")
    public Result register(@RequestBody RecruiterRegisterDto recruiterRegisterDto) {
        return recruiterService.register(recruiterRegisterDto);
    }

    @PostMapping("/login")
    public Result login(@RequestBody RecruiterLoginDto recruiterLoginDto) {
        return recruiterService.login(recruiterLoginDto);
    }

    @DeleteMapping("/logout")
    public Result logout() {
        return recruiterService.logout();
    }

    @PutMapping("/update")
    public Result update(@RequestBody RecruiterInfoDto recruiterInfoDto) {
        return recruiterService.update(recruiterInfoDto);
    }
}
