package com.example.campus.service.impl;

import com.example.campus.entity.Post;
import com.example.campus.mapper.PostMapper;
import com.example.campus.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖子 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
