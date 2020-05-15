package com.example.campus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.campus.entity.Community;
import com.example.campus.mapper.CommunityMapper;
import com.example.campus.service.ICommunityService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 社团 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements ICommunityService {

}
