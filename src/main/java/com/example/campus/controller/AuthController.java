package com.example.campus.controller;

import com.example.campus.common.JwtAuthenticationResponse;
import com.example.campus.entity.OpenIdJson;
import com.example.campus.security.CurrentUser;
import com.example.campus.security.JwtTokenProvider;
import com.example.campus.security.UserPrincipal;
import com.example.campus.utils.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtTokenProvider tokenProvider;

    @Value("${weixin.AppID}")
    private String appID;

    @Value("${weixin.AppSecret}")
    private String appSecret;

    @ApiOperation(value = "统一登陆")
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(String username, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @ApiOperation(value = "获取当前角色身份")
    @GetMapping("/role")
    public ResponseEntity<?> role(@ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        GrantedAuthority authority = userPrincipal.getAuthorities().iterator().next();
        return new ResponseEntity<>(authority.getAuthority(), HttpStatus.OK);
    }

    @GetMapping("wx_auth")
    public ResponseEntity<?> wxAuth(@RequestParam("code") String code) throws JsonProcessingException {
        String result = "";
        try {
            result = HttpUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?appid="
                    + this.appID + "&secret="
                    + this.appSecret + "&js_code="
                    + code
                    + "&grant_type=authorization_code", null);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        OpenIdJson openIdJson = mapper.readValue(result, OpenIdJson.class);
        return new ResponseEntity<>(openIdJson, HttpStatus.OK);
    }
}

