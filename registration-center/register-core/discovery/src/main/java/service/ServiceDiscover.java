package service;

import entity.ServiceInstance;

import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/10
 */
public class ServiceDiscover {
    Random rnd = new Random();

    // 随机发现
    public ServiceInstance discover(String serviceName) {
        List<ServiceInstance> instances = InMemoryRegistry.get(serviceName);
        if (instances == null || instances.isEmpty()) {
            return null;
        }
        int index = rnd.nextInt(instances.size());
        return instances.get(index);
    }
}
