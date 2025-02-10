package com.topview.provider.service;


import api.CalService;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/10
 */
public class CalServiceImpl implements CalService {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a/b;
    }
}
