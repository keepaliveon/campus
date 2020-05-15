package com.example.campus.service;

import com.example.campus.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 学生 服务类
 * </p>
 *
 * @author yangwei
 * @since 2020-05-02
 */
public interface IStudentService extends IService<Student> {
    Student findStudentByOpenId(String openId);

    int countPost(String sid);

    int countCommunity(String sid);
}
