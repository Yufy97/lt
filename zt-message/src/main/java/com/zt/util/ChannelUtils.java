package com.zt.util;

import com.zt.entity.po.User;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.zt.constant.NettyConstant.ATTRIBUTE_KEY_VALUE;


public class ChannelUtils {
    private static Map<Long, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    public static void bind(User user, Channel channel){
        channel.attr(AttributeKey.valueOf(ATTRIBUTE_KEY_VALUE)).set(user);
        userIdChannelMap.put(user.getId(), channel);
    }

    public static void unbind(User user){
        userIdChannelMap.get(user.getId()).attr(AttributeKey.valueOf(ATTRIBUTE_KEY_VALUE)).set(null);
        userIdChannelMap.remove(user.getId());
    }

    public static void unbind(Channel channel){
        User user = getUserByChannel(channel);
        channel.attr(AttributeKey.valueOf(ATTRIBUTE_KEY_VALUE)).set(null);
        userIdChannelMap.remove(user.getId());
    }

    public static Channel getChannelByUserId(Long userId){
        return userIdChannelMap.get(userId);
    }

    public static User getUserByChannel(Channel channel){
        return (User) channel.attr(AttributeKey.valueOf(ATTRIBUTE_KEY_VALUE)).get();
    }

}
