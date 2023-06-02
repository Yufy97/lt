package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.Result;
import com.zt.entity.dto.AddEducationExpDto;
import com.zt.entity.po.EducationExp;
import com.zt.entity.vo.EducationExpInfoVo;
import com.zt.mapper.EducationExpMapper;
import com.zt.service.EducationExpService;
import com.zt.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (EducationExperience)表服务实现类
 *
 * @author makejava
 * @since 2023-05-30 16:22:42
 */
@Service("educationExpService")
public class EducationExpServiceImpl extends ServiceImpl<EducationExpMapper, EducationExp> implements EducationExpService {


    @Override
    public Result getByUserId(Long userId) {
        List<EducationExp> list = lambdaQuery().eq(EducationExp::getUserId, userId).list();
        List<EducationExpInfoVo> educationExpInfoVos = BeanCopyUtils.copyBeanList(list, EducationExpInfoVo.class);
        return Result.okResult(educationExpInfoVos);
    }
}

