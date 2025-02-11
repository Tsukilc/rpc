package infra;

import entity.ServiceInstance;
import service.ServiceDiscover;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/11
 */
public class ServiceDiscoveryClient {

    final private ServiceDiscover serviceDiscover=new ServiceDiscover();
    public ServiceInstance getServiceInstance(String serviceName) {
        return serviceDiscover.discover(serviceName);
    }
}
