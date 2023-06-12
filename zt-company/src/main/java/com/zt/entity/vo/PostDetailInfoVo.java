package com.zt.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class PostDetailInfoVo {

    private RecruiterInfoVo recruiterInfoVo;

    private CompanySimpleInfoVo companySimpleInfoVo;

    private Long id;

    private String name;

    private String salary;

    private String city;

    private Long recruiterId;

    private String introduce;

    private List<PostTagVo> tags;

    private List<PostSchoolVo> schools;
}
