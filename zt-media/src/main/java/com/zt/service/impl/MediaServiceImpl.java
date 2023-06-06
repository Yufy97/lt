package com.zt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.constant.AppHttpCodeEnum;
import com.zt.entity.Result;
import com.zt.entity.po.Media;
import com.zt.handler.exception.SystemException;
import com.zt.mapper.MediaMapper;
import com.zt.service.MediaService;
import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Media)表服务实现类
 *
 * @author makejava
 * @since 2023-05-29 19:24:54
 */
@Service("mediaService")
public class MediaServiceImpl extends ServiceImpl<MediaMapper, Media> implements MediaService {
    @Autowired
    OssServiceImpl ossService;
    @Override
    public Result upload(MultipartFile multipartFile, Boolean isResume) {
        String originalFilename = multipartFile.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        if(BooleanUtils.isTrue(isResume)) {
            if (!suffix.equals(".pdf")) {
                throw new SystemException(AppHttpCodeEnum.FILE_TYPE_ERROR);
            }
        } else {
            if (!suffix.equals(".jpg") && !suffix.equals(".png") && !suffix.equals(".pdf")) {
                throw new SystemException(AppHttpCodeEnum.FILE_TYPE_ERROR);
            }
        }

        String md5 = null;
        try {
            InputStream inputStream = multipartFile.getInputStream();
            md5 = DigestUtils.md5DigestAsHex(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        Media media = lambdaQuery().eq(Media::getId, md5).one();
        if (media == null) {
            media = new Media();
            media.setId(md5);
            media.setFileName(originalFilename);
            media.setUrl(ossService.upload(multipartFile, md5 + suffix));
            save(media);
        }

        return Result.okResult(media);
    }

    @Override
    public Result remove(List<String> keys) {
        ossService.remove(keys);

        List<String> list = keys.stream().map(key -> key.substring(0, key.lastIndexOf("."))).collect(Collectors.toList());
        removeBatchByIds(list);
        return Result.okResult();
    }
}

