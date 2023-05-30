package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.config.JWTUtils;
import com.zt.constant.AppHttpCodeEnum;
import com.zt.constant.MediaConstant;
import com.zt.constant.RedisConstant;
import com.zt.entity.Result;
import com.zt.entity.dto.GraduateLoginDto;
import com.zt.entity.dto.GraduateRegisterDto;
import com.zt.entity.po.Graduate;
import com.zt.entity.po.LoginUser;
import com.zt.entity.vo.GraduateInfoVo;
import com.zt.entity.vo.LoginVo;
import com.zt.mapper.GraduateMapper;
import com.zt.service.GraduateService;
import com.zt.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * (Graduate)表服务实现类
 *
 * @author makejava
 * @since 2023-05-29 19:18:54
 */
@Service("graduateService")
public class GraduateServiceImpl extends ServiceImpl<GraduateMapper, Graduate> implements GraduateService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Result register(GraduateRegisterDto graduateRegisterDto) {
        if(!graduateRegisterDto.getPassword().equals(graduateRegisterDto.getConfirmPassword())){
            return Result.errorResult(AppHttpCodeEnum.DIFFERENT_PASSWORD);
        }

        Graduate one = lambdaQuery().eq(Graduate::getUsername, graduateRegisterDto.getUsername()).one();
        if(one != null) return Result.errorResult(AppHttpCodeEnum.USERNAME_EXIST);

        String password = passwordEncoder.encode(graduateRegisterDto.getPassword());
        graduateRegisterDto.setPassword(password);
        graduateRegisterDto.setAvatar(MediaConstant.DEFAULT_AVATAR);

        Graduate graduate = BeanCopyUtils.copyBean(graduateRegisterDto, Graduate.class);
        save(graduate);
        return Result.okResult();
    }

    @Override
    public Result login(GraduateLoginDto graduateLoginDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(graduateLoginDto.getUsername(),graduateLoginDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        long userId = loginUser.getGraduate().getId();
        String jwt = JWTUtils.createJWT(userId);
        redisTemplate.opsForValue().set(RedisConstant.REDIS_LOGIN_USER + userId, loginUser);
        GraduateInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getGraduate(), GraduateInfoVo.class);
        LoginVo vo = new LoginVo(jwt,userInfoVo);
        return Result.okResult(vo);
    }
}

