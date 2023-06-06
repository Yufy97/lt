package com.zt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.entity.Result;
import com.zt.entity.po.Media;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * (Media)表服务接口
 *
 * @author makejava
 * @since 2023-05-29 19:24:53
 */
public interface MediaService extends IService<Media> {
    Result upload(MultipartFile multipartFile, Boolean isResume);

    Result remove(List<String> keys);
}

