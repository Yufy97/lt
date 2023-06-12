package com.zt.controller;

import com.zt.entity.Result;
import com.zt.entity.dto.PostAddDto;
import com.zt.entity.vo.PostDetailInfoVo;
import com.zt.entity.vo.PostSimpleInfoVo;
import com.zt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public Result add(@RequestBody PostAddDto postAddDto) {
        return postService.add(postAddDto);
    }

    @GetMapping("/{recruiterId}")
    public Result getListByRecruiterId(@PathVariable("recruiterId") Long recruiterId, Integer pageNum, Integer pageSize) {
        List<PostSimpleInfoVo> postVoList = postService.getListByRecruiterId(recruiterId, pageNum, pageSize);
        return Result.okResult(postVoList);
    }

    @GetMapping("/{id}")
    public Result getDetailsById(@PathVariable("id") Long id) {
        PostDetailInfoVo postDetailInfoVo = postService.getDetailsById(id);
        return Result.okResult(postDetailInfoVo);
    }
}
