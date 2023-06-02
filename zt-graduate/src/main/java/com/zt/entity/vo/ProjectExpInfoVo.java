package com.zt.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectExpInfoVo {

    private Long id;

    private String projectName;

    private String beginTime;

    private String endTime;

    private String description;

    private String duty;

    private String url;
}
