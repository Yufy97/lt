package com.zt.mapper;

import com.zt.entity.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from graduate where id = #{id} union select * from hr where id = #{id}")
    User getById(@Param("id") Long id);
}
