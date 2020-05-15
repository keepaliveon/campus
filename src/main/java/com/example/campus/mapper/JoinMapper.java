package com.example.campus.mapper;

import com.example.campus.entity.Join;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 学生加入社团中间表 Mapper 接口
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
public interface JoinMapper extends BaseMapper<Join> {
    List<Join> listAllByCommunity(String cid);
}
