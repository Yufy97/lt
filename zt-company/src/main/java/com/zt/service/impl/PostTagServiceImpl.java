package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.po.PostTag;
import com.zt.mapper.PostTagMapper;
import com.zt.service.PostTagService;
import org.springframework.stereotype.Service;

/**
 * (PostTags)表服务实现类
 *
 * @author makejava
 * @since 2023-06-12 11:28:50
 */
@Service("postTagsService")
public class PostTagServiceImpl extends ServiceImpl<PostTagMapper, PostTag> implements PostTagService {

}

