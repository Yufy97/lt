package com.zt.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class PostAddDto {

    private String name;

    private String salary;

    private String city;

    private Long recruiterId;

    private String introduce;

    private List<String> tags;

    private List<String> schools;
}
