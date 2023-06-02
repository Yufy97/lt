package com.zt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.entity.Result;
import com.zt.entity.po.ProjectExp;


/**
 * (ProjectExp)表服务接口
 *
 * @author makejava
 * @since 2023-05-30 16:50:10
 */
public interface ProjectExpService extends IService<ProjectExp> {

    Result getProjectById(Long userId);
}

