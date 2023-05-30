package com.zt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zt.entity.po.Graduate;
import com.zt.entity.po.LoginUser;
import com.zt.mapper.GraduateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private GraduateMapper graduateMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<Graduate> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Graduate::getUsername,username);
        Graduate user = graduateMapper.selectOne(queryWrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户不存在");
        }
        boolean perms = user.getId() == 1L;
        return new LoginUser(user, perms);
    }
}