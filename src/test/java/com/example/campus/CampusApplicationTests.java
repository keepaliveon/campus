package com.example.campus;

import com.example.campus.entity.Admin;
import com.example.campus.mapper.AdminMapper;
import com.example.campus.utils.UUIDUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class CampusApplicationTests {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        adminMapper.insert(admin);
    }

    @Test
    void t1() {
        System.out.println(UUIDUtil.Id());
        System.out.println(UUIDUtil.SerialNum());
        System.out.println(UUIDUtil.randomId());
    }

}
