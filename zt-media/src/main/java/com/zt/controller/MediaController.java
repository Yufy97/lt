package com.zt.controller;

import com.zt.entity.Result;
import com.zt.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping
public class MediaController {
    @Autowired
    MediaService mediaService;

    @PostMapping("/upload")
    public Result upload(MultipartFile file, Boolean isResume) {
        return mediaService.upload(file, isResume);
    }

    @DeleteMapping("/remove")
    public Result remove(@RequestBody List<String> keys) {
        return mediaService.remove(keys);
    }
}
