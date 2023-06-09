package com.zt.client;

import com.zt.entity.po.Media;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("mediaService")
public interface MediaClient {
    @GetMapping("/media/list")
    List<Media> list(List<String> ids);
}
