package service;

import entity.ServiceInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/10
 */
public class InMemoryRegistry {
    private static final Map<String, List<ServiceInstance>> registry = new HashMap<>();

    public static void register(String serviceName, ServiceInstance instance) {
        registry.putIfAbsent(serviceName, new ArrayList<>());
        registry.get(serviceName).add(instance);
    }

    public static List<ServiceInstance> get(String serviceName) {
        return registry.get(serviceName);
    }
}

