package com.zt.mapper;

import com.zt.entity.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select g.id, nickname, avatar,  school_name as department from graduate g\n" +
            "left join education_exp ee on g.id = ee.user_id\n" +
            "where g.id = #{id}\n" +
            "union\n" +
            "select r.id, nickname, avatar, name as department from recruiters r\n" +
            "left join company c on r.company_id = c.id\n" +
            "where r.id = #{id};")
    User getById(@Param("id") Long id);
}
