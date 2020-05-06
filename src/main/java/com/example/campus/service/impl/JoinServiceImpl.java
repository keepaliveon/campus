package com.example.campus.service.impl;

import com.example.campus.entity.Join;
import com.example.campus.mapper.JoinMapper;
import com.example.campus.service.IJoinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生加入社团中间表 服务实现类
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
@Service
public class JoinServiceImpl extends ServiceImpl<JoinMapper, Join> implements IJoinService {

}
