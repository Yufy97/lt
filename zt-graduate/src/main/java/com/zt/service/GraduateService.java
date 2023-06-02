package com.zt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.entity.Result;
import com.zt.entity.dto.GraduateLoginDto;
import com.zt.entity.dto.GraduateRegisterDto;
import com.zt.entity.po.Graduate;


/**
 * (Graduate)表服务接口
 *
 * @author makejava
 * @since 2023-05-29 19:18:54
 */
public interface GraduateService extends IService<Graduate> {

    Result register(GraduateRegisterDto graduateRegisterDto);

    Result login(GraduateLoginDto graduateLoginDto);

    Result logout();

    Result getInfoById(Long id);

}

