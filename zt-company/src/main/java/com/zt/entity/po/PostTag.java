package com.zt.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (PostTags)表实体类
 *
 * @author makejava
 * @since 2023-06-12 11:28:50
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostTag {
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private Long postId;
    
    private String tag;

    public PostTag(Long postId, String tag) {
        this.postId = postId;
        this.tag = tag;
    }
}

