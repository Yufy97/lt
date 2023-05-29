package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.po.Graduate;
import com.zt.mapper.GraduateMapper;
import com.zt.service.GraduateService;
import org.springframework.stereotype.Service;

/**
 * (Graduate)表服务实现类
 *
 * @author makejava
 * @since 2023-05-29 19:18:54
 */
@Service("graduateService")
public class GraduateServiceImpl extends ServiceImpl<GraduateMapper, Graduate> implements GraduateService {

}

