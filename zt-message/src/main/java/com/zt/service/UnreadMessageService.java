package com.zt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.entity.po.UnreadMessage;

import java.util.List;


/**
 * (Message)表服务接口
 *
 * @author makejava
 * @since 2023-05-18 15:21:24
 */
public interface UnreadMessageService extends IService<UnreadMessage> {

    List<UnreadMessage> getUnreadMessageByUserId(Long id);

    void readMessage(List<Long> ids);
}

