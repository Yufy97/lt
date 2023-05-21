package com.zt.entity.po;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (MessageList)表实体类
 *
 * @author makejava
 * @since 2023-05-20 19:59:34
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageList {
    
    private Long id;
    
    private Long userId;
    
    private Long toUserId;
    
    private String lastMessage;
    
    private LocalDateTime lastTime;

}

