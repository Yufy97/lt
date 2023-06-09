package com.zt.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruiterRegisterDto {

    private String username;

    private String password;

    private String confirmPassword;

    private String nickname;

    private String gender;

}
