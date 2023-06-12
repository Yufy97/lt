package com.zt.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Post)表实体类
 *
 * @author makejava
 * @since 2023-06-12 11:13:57
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    
    private String name;
    
    private String salary;
    
    private String city;
    
    private Long recruiterId;
    
    private String introduce;
}

