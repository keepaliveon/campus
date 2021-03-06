package com.example.campus.security;

import com.example.campus.entity.Admin;
import com.example.campus.entity.Community;
import com.example.campus.mapper.AdminMapper;
import com.example.campus.mapper.CommunityMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private CommunityMapper communityMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        //先检查是否是管理员账户
        Admin admin = adminMapper.selectById(s);
        System.out.println(admin);
        if (admin != null) {
            return UserPrincipal.create(admin);
        }
        //再检查是否是社团账户
        Community community = communityMapper.selectById(s);
        if (community != null) {
            return UserPrincipal.create(community);
        }
        throw new UsernameNotFoundException("not found community or admin : " + s);
    }

}
