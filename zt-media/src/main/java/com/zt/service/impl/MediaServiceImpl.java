package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.po.Media;
import com.zt.mapper.MediaMapper;
import com.zt.service.MediaService;
import org.springframework.stereotype.Service;

/**
 * (Media)表服务实现类
 *
 * @author makejava
 * @since 2023-05-29 19:24:54
 */
@Service("mediaService")
public class MediaServiceImpl extends ServiceImpl<MediaMapper, Media> implements MediaService {

}

