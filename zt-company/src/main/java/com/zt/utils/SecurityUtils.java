package com.zt.utils;

import com.zt.entity.po.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils
{


    public static LoginUser getLoginUser()
    {
        return (LoginUser) getAuthentication().getPrincipal();
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Long getUserId() {
        return getLoginUser().getRecruiter().getId();
    }
}