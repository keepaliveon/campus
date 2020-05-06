package com.example.campus.service.impl;

import com.example.campus.entity.Tag;
import com.example.campus.mapper.TagMapper;
import com.example.campus.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
