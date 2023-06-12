package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.Result;
import com.zt.entity.dto.PostAddDto;
import com.zt.entity.po.PostSchool;
import com.zt.mapper.PostSchoolMapper;
import com.zt.service.PostSchoolService;
import com.zt.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

/**
 * (PostSchool)表服务实现类
 *
 * @author makejava
 * @since 2023-06-12 11:29:25
 */
@Service("postSchoolService")
public class PostSchoolServiceImpl extends ServiceImpl<PostSchoolMapper, PostSchool> implements PostSchoolService {

}

