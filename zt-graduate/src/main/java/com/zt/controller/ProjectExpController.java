package com.zt.controller;

import com.zt.entity.Result;
import com.zt.entity.po.ProjectExp;
import com.zt.service.ProjectExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project_exp")
public class ProjectExpController {

    @Autowired
    ProjectExpService projectExpService;
    @GetMapping("/{id}")
    public Result getProjectExpById(@PathVariable("id") Long userId) {
        return projectExpService.getProjectById(userId);
    }

    @PostMapping
    public Result saveOrUpdateProjectExp(@RequestBody ProjectExp projectExp) {
        projectExpService.saveOrUpdate(projectExp);
        return Result.okResult();
    }

    @DeleteMapping("/{id}")
    public Result removeProjectExp(@PathVariable("id") Long id) {
        projectExpService.removeById(id);
        return Result.okResult();
    }
}
