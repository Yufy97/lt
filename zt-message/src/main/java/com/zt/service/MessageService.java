package com.zt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.entity.po.Message;
import com.zt.entity.vo.MessageVo;

import java.util.List;


/**
 * (Message)表服务接口
 *
 * @author makejava
 * @since 2023-05-18 16:02:40
 */
public interface MessageService extends IService<Message> {

    List<MessageVo> messageHistory(Long fromUserId, Long toUserId, Integer pageNum, Integer pageSize);
}

