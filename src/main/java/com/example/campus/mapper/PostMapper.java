package com.example.campus.mapper;

import com.example.campus.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 帖子 Mapper 接口
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
public interface PostMapper extends BaseMapper<Post> {
    List<Post> listByGroup(Integer gid);
    List<Post> listByStudent(String openid);
}
