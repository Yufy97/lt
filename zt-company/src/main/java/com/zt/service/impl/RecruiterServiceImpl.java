package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.po.Recruiter;
import com.zt.mapper.RecruiterMapper;
import com.zt.service.RecruiterService;
import org.springframework.stereotype.Service;

/**
 * (Recruiters)表服务实现类
 *
 * @author makejava
 * @since 2023-05-29 19:32:11
 */
@Service("recruitersService")
public class RecruiterServiceImpl extends ServiceImpl<RecruiterMapper, Recruiter> implements RecruiterService {

}

