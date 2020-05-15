package com.example.campus.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UUIDUtil {
    public static String randomId() {
        return UUID.randomUUID().toString().replaceAll("-", "") + "-" + new Date().getTime();
    }
    public static String SerialNum() {
        int num = UUID.randomUUID().hashCode();
        num = num < 0 ? -num : num;
        return String.valueOf(num).substring(0, 6);
    }
    public static String Id() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(new Date()) + UUIDUtil.SerialNum();
    }
}