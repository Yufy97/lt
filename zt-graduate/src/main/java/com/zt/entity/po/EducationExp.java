package com.zt.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (EducationExperience)表实体类
 *
 * @author makejava
 * @since 2023-05-30 16:22:42
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationExp {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private Long userId;
    
    private String schoolName;
    
    private Integer graduateYear;
    
    private String degree;

}

