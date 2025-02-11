package rpc;

import entity.ServiceInstance;
import infra.ServiceDiscoveryClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/11
 */
public class ProxyFactory {
    public static <T> T createProxy(Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class[]{interfaceClass},
                new RpcInvocationHandler(interfaceClass)
        );
    }
}
