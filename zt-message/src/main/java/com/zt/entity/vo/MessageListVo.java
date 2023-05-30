package com.zt.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MessageListVo {
    private Long id;

    private Long toUserId;

    private String toUserAvatar;

    private String toUserNickname;

    private String department;

    private String lastMessage;

    private Date lastTime;
}
