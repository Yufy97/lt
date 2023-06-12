package com.zt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.entity.Result;
import com.zt.entity.dto.PostAddDto;
import com.zt.entity.po.Post;
import com.zt.entity.vo.PostDetailInfoVo;
import com.zt.entity.vo.PostSimpleInfoVo;

import java.util.List;


/**
 * (Post)表服务接口
 *
 * @author makejava
 * @since 2023-06-12 11:13:57
 */
public interface PostService extends IService<Post> {

    Result add(PostAddDto postAddDto);

    List<PostSimpleInfoVo> getListByRecruiterId(Long recruiterId,Integer pageNum, Integer pageSize);

    PostDetailInfoVo getDetailsById(Long id);
}

