package com.zt.entity.po;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (CompanyPic)表实体类
 *
 * @author makejava
 * @since 2023-06-07 21:22:17
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyPic {
    
    private Long id;
    
    private Long companyId;
    
    private String mediaId;

}

