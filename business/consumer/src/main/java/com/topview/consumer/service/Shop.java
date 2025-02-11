package com.topview.consumer.service;

import api.CalService;
import infra.ServiceDiscoveryClient;
import rpc.ProxyFactory;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/11
 */

public class Shop {
    public static void main(String[] args) {
        ServiceDiscoveryClient client = new ServiceDiscoveryClient();
        client.getServiceInstance("cal");
        CalService calService= new CalService() ;
        calService = ProxyFactory.createProxy(calService);

        // 创建一个dubbo包，复制原包的invocation类
        // 要有一个代理工厂，能给任意一个接口创建一个动态代理并且返回
        // 要有一个rpc.invoke方法，传入serviceInfo，接口名等，然后通过远程调用+反射这些返回实际的调用结果

    }
}
