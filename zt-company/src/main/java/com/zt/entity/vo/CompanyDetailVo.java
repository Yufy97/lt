package com.zt.entity.vo;

import com.zt.entity.po.Media;
import lombok.Data;

import java.util.List;

@Data
public class CompanyDetailVo {
    private Long id;

    private String name;

    private String logo;

    private String type;

    private String tag;

    private String introduce;

    private String address;

    private List<Media> picture;
}
