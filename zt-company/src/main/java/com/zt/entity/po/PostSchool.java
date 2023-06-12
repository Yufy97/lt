package com.zt.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (PostSchool)表实体类
 *
 * @author makejava
 * @since 2023-06-12 11:29:25
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSchool {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private Long postId;
    
    private String schoolName;

    public PostSchool(Long postId, String schoolName) {
        this.postId = postId;
        this.schoolName = schoolName;
    }
}

