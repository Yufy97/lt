package com.zt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.entity.Result;
import com.zt.entity.dto.RecruiterInfoDto;
import com.zt.entity.dto.RecruiterLoginDto;
import com.zt.entity.dto.RecruiterRegisterDto;
import com.zt.entity.po.Recruiter;


/**
 * (Recruiters)表服务接口
 *
 * @author makejava
 * @since 2023-05-29 19:32:11
 */
public interface RecruiterService extends IService<Recruiter> {

    Result register(RecruiterRegisterDto recruiterRegisterDto);

    Result login(RecruiterLoginDto recruiterLoginDto);

    Result logout();

    Result update(RecruiterInfoDto recruiterInfoDto);
}

