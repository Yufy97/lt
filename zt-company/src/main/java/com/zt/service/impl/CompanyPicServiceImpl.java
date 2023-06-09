package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.po.CompanyPic;
import com.zt.mapper.CompanyPicMapper;
import com.zt.service.CompanyPicService;
import org.springframework.stereotype.Service;

/**
 * (CompanyPic)表服务实现类
 *
 * @author makejava
 * @since 2023-06-07 21:22:17
 */
@Service("companyPicService")
public class CompanyPicServiceImpl extends ServiceImpl<CompanyPicMapper, CompanyPic> implements CompanyPicService {

}

