package com.zt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.entity.po.MessageList;
import com.zt.entity.vo.MessageListVo;

import java.util.List;


/**
 * (MessageList)表服务接口
 *
 * @author makejava
 * @since 2023-05-20 19:59:34
 */
public interface MessageListService extends IService<MessageList> {

    List<MessageListVo> getMessageList(Long userId, Integer pageNum, Integer pageSize);
}

