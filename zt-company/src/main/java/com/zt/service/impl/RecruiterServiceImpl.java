package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.config.JWTUtils;
import com.zt.constant.AppHttpCodeEnum;
import com.zt.constant.MediaConstant;
import com.zt.constant.RedisConstant;
import com.zt.entity.Result;
import com.zt.entity.dto.RecruiterInfoDto;
import com.zt.entity.dto.RecruiterLoginDto;
import com.zt.entity.dto.RecruiterRegisterDto;
import com.zt.entity.po.LoginUser;
import com.zt.entity.po.Recruiter;
import com.zt.entity.vo.LoginVo;
import com.zt.entity.vo.RecruiterInfoVo;
import com.zt.mapper.RecruiterMapper;
import com.zt.service.RecruiterService;
import com.zt.utils.BeanCopyUtils;
import com.zt.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * (Recruiters)表服务实现类
 *
 * @author makejava
 * @since 2023-05-29 19:32:11
 */
@Service("recruitersService")
public class RecruiterServiceImpl extends ServiceImpl<RecruiterMapper, Recruiter> implements RecruiterService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Result register(RecruiterRegisterDto recruiterRegisterDto) {
        if(!recruiterRegisterDto.getPassword().equals(recruiterRegisterDto.getConfirmPassword())){
            return Result.errorResult(AppHttpCodeEnum.DIFFERENT_PASSWORD);
        }

        Recruiter recruiter = lambdaQuery().eq(Recruiter::getUsername, recruiterRegisterDto.getUsername()).one();
        if(recruiter != null) return Result.errorResult(AppHttpCodeEnum.USERNAME_EXIST);

        recruiter = BeanCopyUtils.copyBean(recruiterRegisterDto, Recruiter.class);
        String password = passwordEncoder.encode(recruiterRegisterDto.getPassword());
        recruiter.setPassword(password);
        recruiter.setAvatar(MediaConstant.DEFAULT_AVATAR);
        recruiter.setIntroduce("...");
        save(recruiter);
        return Result.okResult();
    }


    @Override
    public Result login(RecruiterLoginDto recruiterLoginDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(recruiterLoginDto.getUsername(),recruiterLoginDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        long userId = loginUser.getRecruiter().getId();
        String jwt = JWTUtils.createJWT(userId);
        redisTemplate.opsForValue().set(RedisConstant.REDIS_LOGIN_USER + userId, loginUser);
        RecruiterInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getRecruiter(), RecruiterInfoVo.class);
        LoginVo vo = new LoginVo(jwt ,userInfoVo);
        return Result.okResult(vo);
    }

    @Override
    public Result logout() {
        Long userId = SecurityUtils.getUserId();
        redisTemplate.delete(RedisConstant.REDIS_LOGIN_USER + userId);
        return Result.okResult();
    }

    @Override
    public Result update(RecruiterInfoDto recruiterInfoDto) {
        Recruiter recruiter = BeanCopyUtils.copyBean(recruiterInfoDto, Recruiter.class);
        updateById(recruiter);
        return Result.okResult();
    }
}