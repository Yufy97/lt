package com.zt.controller;

import com.zt.entity.Result;
import com.zt.entity.po.GraduateConcern;
import com.zt.service.GraduateConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graduate_concern")
public class GraduateConcernController {
    @Autowired
    GraduateConcernService graduateConcernService;

    @GetMapping
    public Result getGraduateConcernByUserId(Long userId, Integer type, Integer pageNum, Integer pageSize) {
        return graduateConcernService.getGraduateConcernByUserId(userId, type, pageNum, pageSize);
    }

    @PostMapping
    public Result concern(GraduateConcern graduateConcern) {
        return graduateConcernService.concern(graduateConcern);
    }

    @DeleteMapping
    public Result removeGraduateConcernByIds(List<Long> ids) {
        graduateConcernService.removeBatchByIds(ids);
        return Result.okResult();
    }

    @GetMapping("/isConcern")
    public Result isConcern(Long userId, Long concernId) {
        return graduateConcernService.isConcern(userId, concernId);
    }
}
