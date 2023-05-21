package com.zt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.po.MessageList;
import com.zt.entity.vo.MessageListVo;
import com.zt.mapper.MessageListMapper;
import com.zt.service.MessageListService;
import com.zt.utils.BeanCopyUtils;
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

    @Override
    public List<MessageListVo> getMessageList(Long userId, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<MessageList> lqw = new LambdaQueryWrapper<>();
        lqw.eq(MessageList::getUserId, userId);

        Page<MessageList> page = new Page<>(pageNum, pageSize);
        page(page, lqw);
        //todo 头像姓名
        List<MessageListVo> messageListVos = BeanCopyUtils.copyBeanList(page.getRecords(), MessageListVo.class);
        messageListVos.forEach(messageListVo -> {
//                    User user = userService.getById(messageListVo.getToUserId());
                    messageListVo.setToUserAvatar("...");
                    messageListVo.setToUserNickname("...");
                });
        return messageListVos;
    }
}

