import entity.ServiceInstance;

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
}

