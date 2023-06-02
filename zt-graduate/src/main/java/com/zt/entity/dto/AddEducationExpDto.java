package com.zt.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEducationExpDto {

    private Long userId;

    private String schoolName;

    private String major;

    private Integer graduateYear;

    private String degree;

}
