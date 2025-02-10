package entity;

import lombok.Data;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/10
 */
@Data
public class ServiceInstance {
    private String serviceName; // 服务名
    private String host;        // 主机地址
    private int port;           // 端口
    private String metadata;    // 服务元数据（如版本信息等）
}
