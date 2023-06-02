package com.zt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.entity.Result;
import com.zt.entity.po.PersonalDes;


/**
 * (PersonalDes)表服务接口
 *
 * @author makejava
 * @since 2023-05-30 16:59:04
 */
public interface PersonalDesService extends IService<PersonalDes> {

    Result getPersonalDesByUserId(Long userId);
}

