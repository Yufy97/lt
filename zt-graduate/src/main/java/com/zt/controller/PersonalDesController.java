package com.zt.controller;

import com.zt.entity.Result;
import com.zt.entity.po.PersonalDes;
import com.zt.service.PersonalDesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personal_des")
public class PersonalDesController {

    @Autowired
    PersonalDesService personalDesService;

    @GetMapping("/{id}")
    public Result getPersonalDesByUserId(@PathVariable("id") Long userId) {
        return personalDesService.getPersonalDesByUserId(userId);
    }

    @PostMapping
    public Result saveOrUpdatePersonalDes(@RequestBody PersonalDes personalDes) {
        personalDesService.saveOrUpdate(personalDes);
        return Result.okResult();
    }
}
