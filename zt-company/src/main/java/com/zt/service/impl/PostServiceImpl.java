package com.zt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.entity.Result;
import com.zt.entity.dto.PostAddDto;
import com.zt.entity.po.Post;
import com.zt.entity.po.PostSchool;
import com.zt.entity.po.PostTag;
import com.zt.entity.vo.PostDetailInfoVo;
import com.zt.entity.vo.PostSchoolVo;
import com.zt.entity.vo.PostSimpleInfoVo;
import com.zt.entity.vo.PostTagVo;
import com.zt.mapper.PostMapper;
import com.zt.service.*;
import com.zt.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * (Post)表服务实现类
 *
 * @author makejava
 * @since 2023-06-12 11:13:57
 */
@Service("postService")
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
    @Autowired
    PostSchoolService postSchoolService;
    @Autowired
    PostTagService postTagService;
    @Autowired
    CompanyService companyService;
    @Autowired
    RecruiterService recruiterService;
    @Override
    public Result add(PostAddDto postAddDto) {
        Post post = BeanCopyUtils.copyBean(postAddDto, Post.class);
        save(post);

        List<String> tags = postAddDto.getTags();
        List<PostTag> postTags = tags.stream().map(tag -> new PostTag(post.getId(), tag)).collect(Collectors.toList());
        postTagService.saveBatch(postTags);

        List<String> schools = postAddDto.getSchools();
        if(schools != null) {
            List<PostSchool> postSchools = schools.stream().map(school -> new PostSchool(post.getId(), school)).collect(Collectors.toList());
            postSchoolService.saveBatch(postSchools);
        }
        return Result.okResult();
    }

    @Override
    public List<PostSimpleInfoVo> getListByRecruiterId(Long recruiterId, Integer pageNum, Integer pageSize) {
        Page<Post> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Post> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Post::getRecruiterId, recruiterId);
        List<Post> posts = page(page, lqw).getRecords();

        return BeanCopyUtils.copyBeanList(posts, PostSimpleInfoVo.class);
    }


    @Override
    public PostDetailInfoVo getDetailsById(Long id) {
        Post post = getById(id);
        PostDetailInfoVo postDetailInfoVo = BeanCopyUtils.copyBean(post, PostDetailInfoVo.class);

        postDetailInfoVo.setRecruiterInfoVo(recruiterService.getInfoById(post.getRecruiterId()));
        postDetailInfoVo.setCompanySimpleInfoVo(companyService.getSimpleInfo(postDetailInfoVo.getRecruiterId()));

        List<PostTag> postTags = postTagService.lambdaQuery().eq(PostTag::getPostId, post.getId()).list();
        List<PostTagVo> tags = BeanCopyUtils.copyBeanList(postTags, PostTagVo.class);

        List<PostSchool> postSchools = postSchoolService.lambdaQuery().eq(PostSchool::getPostId, post.getId()).list();
        List<PostSchoolVo> schools = BeanCopyUtils.copyBeanList(postSchools, PostSchoolVo.class);

        postDetailInfoVo.setTags(tags);
        postDetailInfoVo.setSchools(schools);
        return postDetailInfoVo;
    }
}

