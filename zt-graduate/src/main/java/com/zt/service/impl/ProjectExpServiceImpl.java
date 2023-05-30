package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.po.ProjectExp;
import com.zt.mapper.ProjectExpMapper;
import com.zt.service.ProjectExpService;
import org.springframework.stereotype.Service;

/**
 * (ProjectExp)表服务实现类
 *
 * @author makejava
 * @since 2023-05-30 16:50:10
 */
@Service("projectExpService")
public class ProjectExpServiceImpl extends ServiceImpl<ProjectExpMapper, ProjectExp> implements ProjectExpService {

}

