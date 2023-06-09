package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.client.MediaClient;
import com.zt.entity.Result;
import com.zt.entity.dto.CompanySaveDto;
import com.zt.entity.po.Company;
import com.zt.entity.po.CompanyPic;
import com.zt.entity.po.Media;
import com.zt.entity.po.Recruiter;
import com.zt.entity.vo.CompanyDetailVo;
import com.zt.entity.vo.CompanySimpleInfoVo;
import com.zt.mapper.CompanyMapper;
import com.zt.service.CompanyPicService;
import com.zt.service.CompanyService;
import com.zt.service.RecruiterService;
import com.zt.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Company)表服务实现类
 *
 * @author makejava
 * @since 2023-05-29 19:30:23
 */
@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Autowired
    RecruiterService recruiterService;
    @Autowired
    CompanyPicService companyPicService;
    @Autowired
    MediaClient mediaClient;

    @Override
    public Result save(CompanySaveDto companySaveDto) {
        Company company = BeanCopyUtils.copyBean(companySaveDto, Company.class);
        save(company);

        Long recruiterId = companySaveDto.getRecruiterId();
        recruiterService.lambdaUpdate().setSql("company_id = " + company.getId()).eq(Recruiter::getId, recruiterId).update();
        return Result.okResult();
    }

    @Override
    public Result getSimpleInfo(Long recruiterId) {
        Recruiter recruiter = recruiterService.getById(recruiterId);
        Long companyId = recruiter.getCompanyId();
        Company company = getById(companyId);
        CompanySimpleInfoVo companySimpleInfoVo = BeanCopyUtils.copyBean(company, CompanySimpleInfoVo.class);
        return Result.okResult(companySimpleInfoVo);
    }

    @Override
    public Result getDetailInfo(Long companyId) {
        Company company = getById(companyId);
        CompanyDetailVo companyDetailVo = BeanCopyUtils.copyBean(company, CompanyDetailVo.class);

        List<CompanyPic> companyPics = companyPicService.lambdaQuery().eq(CompanyPic::getCompanyId, companyId).list();
        List<String> mediaIds = companyPics.stream().map(CompanyPic::getMediaId).collect(Collectors.toList());
        List<Media> picture = mediaClient.list(mediaIds);

        companyDetailVo.setPicture(picture);
        return Result.okResult();
    }
}

