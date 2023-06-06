package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.Result;
import com.zt.entity.dto.GraduateConcernDto;
import com.zt.entity.po.GraduateConcern;
import com.zt.mapper.GraduateConcernMapper;
import com.zt.service.GraduateConcernService;
import com.zt.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * 我的收藏(学生端)(GraduateConcern)表服务实现类
 *
 * @author makejava
 * @since 2023-06-02 12:07:45
 */
@Service("graduateConcernService")
public class GraduateConcernServiceImpl extends ServiceImpl<GraduateConcernMapper, GraduateConcern> implements GraduateConcernService {

    @Override
    public Result getGraduateConcernByUserId(Long userId, Integer type, Integer pageNum, Integer pageSize) {
        GraduateConcernMapper graduateConcernMapper = getBaseMapper();
        List<Long> concernIds = graduateConcernMapper.selectGraduateConcernByUserId(userId, type, (pageNum - 1) * pageSize, pageSize);
        //todo 获取关注信息
        if(type == 0) {

        } else {

        }
        return null;
    }

    @Override
    public Result isConcern(Long userId, Long concernId) {
        Long count = lambdaQuery().eq(GraduateConcern::getUserId, userId).eq(GraduateConcern::getConcernId, concernId).count();
        return Result.okResult(count > 0);
    }

    @Override
    public Result concern(GraduateConcernDto graduateConcernDto) {
        GraduateConcern graduateConcern = lambdaQuery().eq(GraduateConcern::getUserId, graduateConcernDto.getUserId()).eq(GraduateConcern::getConcernId, graduateConcernDto.getConcernId()).one();
        if(graduateConcern == null) {
            graduateConcern = BeanCopyUtils.copyBean(graduateConcernDto, GraduateConcern.class);
            graduateConcern.setCreateTime(LocalDate.now());
            save(graduateConcern);
        } else {
            removeById(graduateConcern.getId());
        }
        return Result.okResult();
    }
}

