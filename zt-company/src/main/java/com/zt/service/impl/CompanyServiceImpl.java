package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.po.Company;
import com.zt.mapper.CompanyMapper;
import com.zt.service.CompanyService;
import org.springframework.stereotype.Service;

/**
 * (Company)表服务实现类
 *
 * @author makejava
 * @since 2023-05-29 19:30:23
 */
@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

}

