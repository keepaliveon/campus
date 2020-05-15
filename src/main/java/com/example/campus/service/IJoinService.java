package com.example.campus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.campus.entity.Join;

import java.util.List;

/**
 * <p>
 * 学生加入社团中间表 服务类
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
public interface IJoinService extends IService<Join> {
    List<Join> listAllByCommunity(String cid);
}
