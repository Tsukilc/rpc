package rpc;

import lombok.Data;

/**
 * @Description:
 * @Author: zbj
 * @Date: 2025/2/11
 */
@Data
public class Invocation {
    private String serviceName; // 服务名称
    private String methodName;  // 方法名称
    private Class<?>[] parameterTypes; // 参数类型
    private Object[] arguments; // 参数
    private String serviceAddress; // 服务地址（包括主机和端口）
}
