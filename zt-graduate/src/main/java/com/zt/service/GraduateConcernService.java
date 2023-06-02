package com.zt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.entity.Result;
import com.zt.entity.po.GraduateConcern;


/**
 * 我的收藏(学生端)(GraduateConcern)表服务接口
 *
 * @author makejava
 * @since 2023-06-02 12:07:45
 */
public interface GraduateConcernService extends IService<GraduateConcern> {

    Result getGraduateConcernByUserId(Long userId, Integer type, Integer pageNum, Integer pageSize);

    Result isConcern(Long userId, Long concernId);

    Result concern(GraduateConcern graduateConcern);

}

