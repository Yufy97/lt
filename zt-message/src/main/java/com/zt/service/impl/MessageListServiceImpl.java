package com.zt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.po.MessageList;
import com.zt.entity.po.User;
import com.zt.entity.vo.MessageListVo;
import com.zt.mapper.MessageListMapper;
import com.zt.mapper.UserMapper;
import com.zt.service.MessageListService;
import com.zt.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (MessageList)表服务实现类
 *
 * @author makejava
 * @since 2023-05-20 19:59:34
 */
@Service("messageListService")
public class MessageListServiceImpl extends ServiceImpl<MessageListMapper, MessageList> implements MessageListService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<MessageListVo> getMessageList(Long userId, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<MessageList> lqw = new LambdaQueryWrapper<>();
        lqw.eq(MessageList::getUserId, userId);

        Page<MessageList> page = new Page<>(pageNum, pageSize);
        page(page, lqw);
        List<MessageListVo> messageListVos = BeanCopyUtils.copyBeanList(page.getRecords(), MessageListVo.class);
        messageListVos.forEach(messageListVo -> {
                    User user = userMapper.getById(messageListVo.getToUserId());
                    messageListVo.setToUserAvatar(user.getAvatar());
                    messageListVo.setToUserNickname(user.getNickname());
                });
        return messageListVos;
    }
}

