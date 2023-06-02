package com.zt.controller;

import com.zt.entity.Result;
import com.zt.entity.po.EducationExp;
import com.zt.service.EducationExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/education_exp")
public class EducationExpController {

    @Autowired
    EducationExpService educationExpService;

    @GetMapping("/{id}")
    public Result getByUserId(@PathVariable("id") Long userId) {
        return educationExpService.getByUserId(userId);
    }

    @PostMapping
    public Result addEducationExp(@RequestBody EducationExp educationExp) {
        educationExpService.saveOrUpdate(educationExp);
        return Result.okResult();
    }

    @DeleteMapping("/{id}")
    public Result remove(@PathVariable Long id) {
        educationExpService.removeById(id);
        return Result.okResult();
    }
}
