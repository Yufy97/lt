package com.zt.controller;

import com.zt.entity.vo.MessageVo;
import com.zt.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/messageHistory")
    public List<MessageVo> messageHistory(Long fromUserId, Long toUserId, Integer pageNum, Integer pageSize) {
        return messageService.messageHistory(fromUserId, toUserId, pageNum, pageSize);
    }
}
