package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.Result;
import com.zt.entity.po.ProjectExp;
import com.zt.entity.vo.ProjectExpInfoVo;
import com.zt.mapper.ProjectExpMapper;
import com.zt.service.ProjectExpService;
import com.zt.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (ProjectExp)表服务实现类
 *
 * @author makejava
 * @since 2023-05-30 16:50:10
 */
@Service("projectExpService")
public class ProjectExpServiceImpl extends ServiceImpl<ProjectExpMapper, ProjectExp> implements ProjectExpService {

    @Override
    public Result getProjectById(Long userId) {
        List<ProjectExp> projectExps = lambdaQuery().eq(ProjectExp::getUserId, userId).list();
        List<ProjectExpInfoVo> projectExpInfoVos = BeanCopyUtils.copyBeanList(projectExps, ProjectExpInfoVo.class);
        return Result.okResult(projectExpInfoVos);
    }
}

