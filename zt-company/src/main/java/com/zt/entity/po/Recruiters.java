package com.zt.entity.po;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Recruiters)表实体类
 *
 * @author makejava
 * @since 2023-05-29 19:32:11
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recruiters {
    
    private Long id;
    
    private String username;
    
    private String password;
    
    private String nickname;
    
    private String avatar;
    
    private String gender;
    
    private Long companyId;
    
    private String introduce;

}

