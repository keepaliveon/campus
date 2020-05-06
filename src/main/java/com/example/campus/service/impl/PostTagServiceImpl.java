package com.example.campus.service.impl;

import com.example.campus.entity.PostTag;
import com.example.campus.mapper.PostTagMapper;
import com.example.campus.service.IPostTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖子标签 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Service
public class PostTagServiceImpl extends ServiceImpl<PostTagMapper, PostTag> implements IPostTagService {

}
