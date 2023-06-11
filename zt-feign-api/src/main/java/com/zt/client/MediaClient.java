package com.zt.client;

import com.zt.entity.po.Media;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient("media-service")
public interface MediaClient {
    @GetMapping(value = "/media/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Media> list(List<String> ids);
}
