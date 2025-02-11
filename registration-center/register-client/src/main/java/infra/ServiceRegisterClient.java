package infra;

import dto.ServiceRegisterDto;
import entity.ServiceInstance;
import service.ServiceRegister;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/10
 */
public class ServiceRegisterClient {

    ServiceRegister serviceRegister = new ServiceRegister();

    // 先简化一下，直接调用吧
    // todo：不能直接调用，还是要单独创建已一个进程，可以研究一下用什么方式调用注册中心
    public void register(ServiceRegisterDto dto) {
        ServiceInstance instance = new ServiceInstance();
        instance.setServiceName(dto.getServiceName());
        instance.setHost(dto.getServiceAddress());
        instance.setPort(Integer.parseInt(dto.getServicePort()));
        serviceRegister.register(instance);
    }
}
