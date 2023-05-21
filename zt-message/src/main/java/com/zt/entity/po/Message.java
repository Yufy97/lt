package com.zt.entity.po;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Message)表实体类
 *
 * @author makejava
 * @since 2023-05-18 16:02:40
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@TableName("message")
public class Message {
    @TableId
    private Long id;
    
    private Long fromUserId;
    
    private Long toUserId;
    
    private String message;
    
    private LocalDateTime time;

    public Message(Long fromUserId, Long toUserId, String message, LocalDateTime time) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.message = message;
        this.time = time;
    }
}

