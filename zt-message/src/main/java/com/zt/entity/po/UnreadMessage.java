package com.zt.entity.po;

import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.toolkit.*;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * (Message)表实体类
 *
 * @author makejava
 * @since 2023-05-18 15:21:24
 */
@Data
@TableName("unread_message")
@AllArgsConstructor
public class UnreadMessage {
    @TableId
    private Long id;
    
    private Long fromUserId;
    
    private Long toUserId;
    
    private String message;
    
    private LocalDateTime time;

    public UnreadMessage(Long fromUserId, Long toUserId, String message, LocalDateTime time) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.message = message;
        this.time = time;
    }
}

