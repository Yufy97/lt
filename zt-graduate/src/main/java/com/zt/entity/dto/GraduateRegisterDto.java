package com.zt.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GraduateRegisterDto {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "密码不能为空")
    private String confirmPassword;

    private String nickname;

    private String avatar;

    private String gender;

    private Integer birthday;
}
