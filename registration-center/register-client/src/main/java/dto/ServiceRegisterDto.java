package dto;

import lombok.Data;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/10
 */
@Data
public class ServiceRegisterDto {
    private String serviceName;

    private String serviceAddress;

    private String servicePort;


    public ServiceRegisterDto(String serviceName, String serviceAddress, String servicePort) {
        this.serviceName = serviceName;
        this.serviceAddress = serviceAddress;
        this.servicePort = servicePort;
    }
}
