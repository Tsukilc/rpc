package rpc;

import entity.ServiceInstance;
import infra.ServiceDiscoveryClient;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/11
 */
public class RpcInvocationHandler implements InvocationHandler {

    private final Class<?> interfaceClass;

    public RpcInvocationHandler(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Invocation invocation = new Invocation();
        invocation.setServiceName(interfaceClass.getName());
        invocation.setMethodName(method.getName());
        invocation.setParameterTypes(method.getParameterTypes());
        invocation.setArguments(args);

        // 获取服务实例
        ServiceDiscoveryClient serviceDiscoveryClient = new ServiceDiscoveryClient();
        ServiceInstance serviceInstance = serviceDiscoveryClient.getServiceInstance(interfaceClass.getName());
        Assert.notNull(serviceInstance,"serviceInstance not found");
        invocation.setServiceAddress(serviceInstance.getHost());

        // 执行远程调用
        // todo: netty客户端和服务器建立连接后，要有心跳检测等，还要把调用的方法抽离出来等，参考kitex那写的
        return RpcClient.invoke(invocation);
    }
}