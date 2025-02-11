package service;

import entity.ServiceInstance;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/10
 */
public class ServiceRegister {
    public void register(ServiceInstance instance) {
        InMemoryRegistry.register(instance.getServiceName(), instance);
    }
}
