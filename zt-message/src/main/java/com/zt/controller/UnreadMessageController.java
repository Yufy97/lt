package com.zt.controller;

import com.zt.entity.po.UnreadMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zt.service.UnreadMessageService;

import java.util.List;

@RestController
public class UnreadMessageController {
    @Autowired
    UnreadMessageService unreadMessageService;


    @GetMapping("/unreadMessage")
    public List<UnreadMessage> getUnreadMessageByUserId(Long id) {
        return unreadMessageService.getUnreadMessageByUserId(id);
    }

    @DeleteMapping("/readMessage")
    public void readMessage(@RequestBody List<Long> ids) {
        unreadMessageService.readMessage(ids);
    }
}
