package com.example.campus.service;

import com.example.campus.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 帖子 服务类
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
public interface IPostService extends IService<Post> {
    List<Post> listByGroup(Integer gid);
}
