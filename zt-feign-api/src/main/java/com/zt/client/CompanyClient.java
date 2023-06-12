package com.zt.client;

import com.zt.entity.vo.CompanySimpleInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("company-service")
public interface CompanyClient {
    @GetMapping(value = "/api/simple_info_list", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<CompanySimpleInfoVo> getSimpleInfoListApi(List<Long> companyIds);
}
