package com.zt.controller;

import com.zt.entity.Result;
import com.zt.entity.dto.CompanySaveDto;
import com.zt.entity.vo.CompanySimpleInfoVo;
import com.zt.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping("/save")
    public Result save(@RequestBody CompanySaveDto companySaveDto) {
        return companyService.save(companySaveDto);
    }

    @GetMapping("/simple_info")
    public Result getSimpleInfo(Long recruiterId) {
        return Result.okResult(companyService.getSimpleInfo(recruiterId));
    }

    @GetMapping("/api/simple_info_list")
    public List<CompanySimpleInfoVo> getSimpleInfoListApi(@RequestBody List<Long> companyIds){
        return companyService.getSimpleInfoListApi(companyIds);
    }

    @GetMapping("/detail_info")
    public Result getDetailInfo(Long companyId) {
        return companyService.getDetailInfo(companyId);
    }
}
