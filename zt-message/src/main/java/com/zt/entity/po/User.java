package com.zt.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class User {

    private Long id;

    private String nickname;

    private String avatar;

    private String department;
}
