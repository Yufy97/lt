package com.zt.controller;

import com.zt.entity.Result;
import com.zt.entity.dto.GraduateLoginDto;
import com.zt.entity.dto.GraduateRegisterDto;
import com.zt.entity.po.Graduate;
import com.zt.service.GraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/graduate")
public class GraduateController {

    @Autowired
    GraduateService graduateService;

    @GetMapping("/{id}")
    public Result getInfoById(@PathVariable("id") Long id) {
        return graduateService.getInfoById(id);
    }
    @PostMapping("/register")
    public Result register(@RequestBody @Validated GraduateRegisterDto graduateRegisterDto) {
        return graduateService.register(graduateRegisterDto);
    }

    @GetMapping("/login")
    public Result login(@RequestBody @Validated GraduateLoginDto graduateLoginDto) {
        return graduateService.login(graduateLoginDto);
    }

    @DeleteMapping("/logout")
    public Result logout() {
        return graduateService.logout();
    }

    @PutMapping
    public Result update(@RequestBody Graduate graduate) {
        graduateService.updateById(graduate);
        return Result.okResult();
    }
}
