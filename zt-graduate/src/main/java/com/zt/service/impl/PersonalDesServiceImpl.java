package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.po.PersonalDes;
import com.zt.mapper.PersonalDesMapper;
import com.zt.service.PersonalDesService;
import org.springframework.stereotype.Service;

/**
 * (PersonalDes)表服务实现类
 *
 * @author makejava
 * @since 2023-05-30 16:59:04
 */
@Service("personalDesService")
public class PersonalDesServiceImpl extends ServiceImpl<PersonalDesMapper, PersonalDes> implements PersonalDesService {

}

