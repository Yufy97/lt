package com.zt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zt.entity.po.GraduateConcern;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 我的收藏(学生端)(GraduateConcern)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-02 12:07:45
 */
public interface GraduateConcernMapper extends BaseMapper<GraduateConcern> {

    @Select("select concern_id from graduate_concern \n" +
            "where user_id = #{userId} and type = #{type}\n" +
            "order by create_time desc \n" +
            "limit #{pageNum} #{pageSize}")
    List<Long> selectGraduateConcernByUserId(Long userId, Integer type, Integer pageNum, Integer pageSize);
}

