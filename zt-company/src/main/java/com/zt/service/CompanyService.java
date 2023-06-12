package com.zt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.entity.Result;
import com.zt.entity.dto.CompanySaveDto;
import com.zt.entity.po.Company;
import com.zt.entity.vo.CompanySimpleInfoVo;

import java.util.List;


/**
 * (Company)表服务接口
 *
 * @author makejava
 * @since 2023-05-29 19:30:22
 */
public interface CompanyService extends IService<Company> {

    Result save(CompanySaveDto companySaveDto);

    CompanySimpleInfoVo getSimpleInfo(Long recruiterId);

    Result getDetailInfo(Long companyId);

    List<CompanySimpleInfoVo> getSimpleInfoListApi(List<Long> companyIds);
}

