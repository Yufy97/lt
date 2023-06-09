package com.zt.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Media)表实体类
 *
 * @author makejava
 * @since 2023-05-29 19:24:53
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    
    private String id;
    
    private String fileName;
    
    private String url;


}

