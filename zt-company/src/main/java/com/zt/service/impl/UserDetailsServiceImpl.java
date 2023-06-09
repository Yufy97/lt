package com.zt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zt.entity.po.LoginUser;
import com.zt.entity.po.Recruiter;
import com.zt.mapper.RecruiterMapper;
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
    private RecruiterMapper graduateMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<Recruiter> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Recruiter::getUsername,username);
        Recruiter user = graduateMapper.selectOne(queryWrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户不存在");
        }

        return new LoginUser(user, null);
    }
}