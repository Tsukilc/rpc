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
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Invocation invocation = new Invocation();
                        invocation.setServiceName(interfaceClass.getName());
                        invocation.setMethodName(method.getName());
                        invocation.setParameterTypes(method.getParameterTypes());
                        invocation.setArguments(args);

                        // 这里暂时只提供一种方式吧，从注册中心挖
                        ServiceDiscoveryClient serviceDiscoveryClient = new ServiceDiscoveryClient();
                        ServiceInstance serviceInstance = serviceDiscoveryClient.getServiceInstance(interfaceClass.getName());
                        invocation.setServiceAddress(serviceInstance.getHost());
                        // return RpcClient.invoke(invocation);
                    }
                }
        );
    }


}
