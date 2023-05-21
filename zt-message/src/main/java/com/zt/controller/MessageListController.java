package com.zt.controller;

import com.zt.entity.vo.MessageListVo;
import com.zt.service.MessageListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageListController {

    @Autowired
    MessageListService messageListService;

    @GetMapping("/messageList")
    public List<MessageListVo> getMessageList(Long userId, Integer pageNum, Integer pageSize) {
        return messageListService.getMessageList(userId, pageNum, pageSize);
    }
}
