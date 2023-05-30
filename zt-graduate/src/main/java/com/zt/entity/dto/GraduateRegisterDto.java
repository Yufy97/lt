package com.zt.entity.dto;

import lombok.Data;

@Data
public class GraduateRegisterDto {

    private String username;

    private String password;

    private String confirmPassword;

    private String nickname;

    private String avatar;

    private String gender;

    private Integer birthday;
}
