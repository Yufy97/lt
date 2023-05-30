package com.zt.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (ProjectExp)表实体类
 *
 * @author makejava
 * @since 2023-05-30 16:50:10
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectExp {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private Long userId;
    
    private String projectName;
    
    private String beginTime;
    
    private String endTime;
    
    private String description;
    
    private String duty;
    
    private String url;

}

