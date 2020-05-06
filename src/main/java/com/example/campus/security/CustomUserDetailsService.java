package com.example.campus.security;

import com.example.campus.entity.Admin;
import com.example.campus.entity.Student;
import com.example.campus.mapper.AdminMapper;
import com.example.campus.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    private StudentMapper studentMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Student student = studentMapper.selectById(s);
        if (student != null) {
            return UserPrincipal.create(student);
        }
        Admin admin = adminMapper.selectById(s);
        if (admin != null) {
            return UserPrincipal.create(admin);
        }
        throw new UsernameNotFoundException("not found student counsellor or admin : " + s);
    }

}
