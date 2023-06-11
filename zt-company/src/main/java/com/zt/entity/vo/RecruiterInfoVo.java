package com.zt.entity.vo;

import lombok.Data;

@Data
public class RecruiterInfoVo {
    private Long id;

    private String nickname;

    private String avatar;

    private String gender;

    private Long companyId;

    private String introduce;
}
