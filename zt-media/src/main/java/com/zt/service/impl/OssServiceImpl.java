package com.zt.service.impl;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.zt.constant.AppHttpCodeEnum;
import com.zt.constant.OssConstant;
import com.zt.handler.exception.SystemException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Service
public class OssServiceImpl {
    @Value("${oss.accessKey}")
    private String accessKey;

    @Value("${oss.secretKey}")
    private String secretKey;

    @Value("${oss.bucket}")
    private String bucket;



    public String upload(MultipartFile multipartFile, String fileName) {
        Configuration cfg = new Configuration(Region.autoRegion());
        UploadManager uploadManager = new UploadManager(cfg);

        Auth auth = Auth.create(accessKey, secretKey);
        String filePath = "zt/" + fileName;

        try {
            InputStream inputStream = multipartFile.getInputStream();
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(inputStream, filePath, upToken,null, null);
                return OssConstant.OSS_URL + filePath;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    throw new SystemException(AppHttpCodeEnum.SYSTEM_ERROR);
                }
            }
        } catch (Exception ex) {
            throw new SystemException(AppHttpCodeEnum.SYSTEM_ERROR);
        }
        return null;
    }


    public void remove(List<String> keys) {
        Auth auth = Auth.create(accessKey, secretKey);
        Configuration config = new Configuration(Region.autoRegion());
        BucketManager bucketMgr = new BucketManager(auth, config);
        keys.forEach(key -> {
            try {
                bucketMgr.delete(bucket, "zt/" + key);
            } catch (QiniuException e) {
                throw new SystemException(AppHttpCodeEnum.SYSTEM_ERROR);
            }
        });
    }
}
