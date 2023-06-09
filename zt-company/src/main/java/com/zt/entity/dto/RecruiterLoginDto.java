package com.zt.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecruiterLoginDto {
    private String username;

    private String password;
}
