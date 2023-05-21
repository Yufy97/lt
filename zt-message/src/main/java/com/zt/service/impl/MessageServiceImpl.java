package com.zt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.po.Message;
import com.zt.entity.vo.MessageVo;
import com.zt.mapper.MessageMapper;
import com.zt.service.MessageService;
import com.zt.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Message)表服务实现类
 *
 * @author makejava
 * @since 2023-05-18 16:02:40
 */
@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Override
    public List<MessageVo> messageHistory(Long fromUserId, Long toUserId, Integer pageNum, Integer pageSize) {
        Page<Message> page = new Page(pageNum, pageSize);

        LambdaQueryWrapper<Message> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Message::getFromUserId, fromUserId).eq(Message::getToUserId, toUserId);

        page(page, lqw);
        List<Message> messages = page.getRecords();

        return BeanCopyUtils.copyBeanList(messages, MessageVo.class);
    }
}

