package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.po.Message;
import com.zt.entity.po.UnreadMessage;
import com.zt.mapper.UnreadMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zt.service.MessageService;
import com.zt.service.UnreadMessageService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * (UnreadMessage)表服务实现类
 *
 * @author makejava
 * @since 2023-05-18 15:49:27
 */
@Service("unreadMessageService")
public class UnreadMessageServiceImpl extends ServiceImpl<UnreadMessageMapper, UnreadMessage> implements UnreadMessageService {

    @Autowired
    MessageService messageService;

    @Override
    public List<UnreadMessage> getUnreadMessageByUserId(Long id) {
        return lambdaQuery().eq(UnreadMessage::getToUserId, id).list();
    }

    @Override
    public void readMessage(List<Long> ids) {
        List<UnreadMessage> unreadMessages = listByIds(ids);
        List<Message> messages = unreadMessages.stream()
                .map(unreadMessage -> new Message(unreadMessage.getFromUserId(),
                        unreadMessage.getToUserId(),
                        unreadMessage.getMessage(),
                        unreadMessage.getTime())).collect(Collectors.toList());
        messageService.saveBatch(messages);
        removeBatchByIds(ids);
    }
}

