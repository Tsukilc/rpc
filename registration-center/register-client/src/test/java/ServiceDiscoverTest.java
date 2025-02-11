import dto.ServiceRegisterDto;
import entity.ServiceInstance;
import infra.ServiceDiscoveryClient;
import infra.ServiceRegisterClient;
import org.junit.jupiter.api.Test;
import service.ServiceDiscover;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/11
 */
public class ServiceDiscoverTest {

    @Test
    public void test() {
        ServiceRegisterClient client = new ServiceRegisterClient();
        ServiceRegisterDto dto = new ServiceRegisterDto();
        dto.setServiceName("test");
        dto.setServiceAddress("127.0.0.1");
        dto.setServicePort("8080");
        client.register(dto);

        ServiceDiscoveryClient discoveryClient = new ServiceDiscoveryClient();
        ServiceInstance instance =discoveryClient.getServiceInstance("test");
        System.out.println(instance.getHost());
    }
}
