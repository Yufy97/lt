package com.zt.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class User {

    private Long id;

    private String username;

    private String password;

    private String nickname;

    private String avatar;

    private String gender;

}
