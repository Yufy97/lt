package com.zt.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationExpInfoVo {
    private Long id;

    private String schoolName;

    private String major;

    private Integer graduateYear;

    private String degree;
}
