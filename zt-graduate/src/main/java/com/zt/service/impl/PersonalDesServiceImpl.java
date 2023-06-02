package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.Result;
import com.zt.entity.po.PersonalDes;
import com.zt.entity.vo.PersonalDesVo;
import com.zt.mapper.PersonalDesMapper;
import com.zt.service.PersonalDesService;
import com.zt.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

/**
 * (PersonalDes)表服务实现类
 *
 * @author makejava
 * @since 2023-05-30 16:59:04
 */
@Service("personalDesService")
public class PersonalDesServiceImpl extends ServiceImpl<PersonalDesMapper, PersonalDes> implements PersonalDesService {

    @Override
    public Result getPersonalDesByUserId(Long userId) {
        PersonalDes personalDes = lambdaQuery().eq(PersonalDes::getUserId, userId).one();
        PersonalDesVo personalDesVo = BeanCopyUtils.copyBean(personalDes, PersonalDesVo.class);
        return Result.okResult(personalDesVo);
    }
}

