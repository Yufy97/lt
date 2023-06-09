package com.zt.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraduateInfoVo {
    private Long id;

    private String nickname;

    private String avatar;

    private String gender;

    private Integer birthday;

    private String desc;
}
