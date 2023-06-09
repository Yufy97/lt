package com.zt.entity.dto;

import lombok.Data;

@Data
public class CompanySaveDto {
    private String name;

    private String logo;

    private String type;

    private String tag;

    private String introduce;

    private String address;

    private Long recruiterId;
}
