package com.zt.entity.po;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Company)表实体类
 *
 * @author makejava
 * @since 2023-05-29 19:30:22
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    
    private Long id;
    
    private String name;
    
    private String logo;
    
    private String type;
    
    private String tag;
    
    private String introduce;
    
    private String address;
    
    private String picture;

}

