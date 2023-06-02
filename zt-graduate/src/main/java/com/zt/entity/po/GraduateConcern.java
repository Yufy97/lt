package com.zt.entity.po;

import java.time.LocalDate;
import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 我的收藏(学生端)(GraduateConcern)表实体类
 *
 * @author makejava
 * @since 2023-06-02 12:07:45
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraduateConcern {
    
    private Long id;
    
    private Long userId;
    //0是公司，1是职位
    private Integer type;
    
    private Long concernId;
    
    private LocalDate createTime;

}

