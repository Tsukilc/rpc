com.nacos.simulation
│
├── core
│   ├── discovery              // 服务发现模块
│   │   ├── ServiceRegistry    // 服务注册
│   │   ├── service.ServiceRegister   // 服务发现
│   │   └── ServiceInstance    // 服务实例
│   │
│   ├── config                 // 配置管理模块
│   │   ├── ConfigService      // 配置读取与写入
│   │   ├── ConfigListener     // 配置变更监听
│   │   └── ConfigSnapshot     // 配置快照管理
│   │
│   ├── registry               // 注册中心模块（例如，基于内存或数据库）
│   │   ├── service.InMemoryRegistry   // 内存注册中心实现
│   │   ├── DatabaseRegistry   // 数据库注册中心实现（如 MySQL、H2 等）
│   │   └── NacosProtocol      // 网络协议层（如 HTTP 或 gRPC）
│   │
│   ├── cluster                // 集群管理与高可用
│   │   ├── ClusterManager     // 集群管理器，负责任务分配和状态同步
│   │   ├── Failover           // 容错机制，支持重试、备份等
│   │   └── LoadBalancer       // 负载均衡策略
│   │
├── web
│   ├── controller             // Web 层，提供服务接口（如 REST API）
│   │   ├── ServiceController  // 服务注册、注销、发现相关接口
│   │   ├── ConfigController   // 配置管理相关接口
│   │   └── HealthController   // 健康检查与监控接口
│   │
│   ├── dto                    // 数据传输对象（DTO）
│   │   ├── ServiceDTO         // 服务数据传输对象
│   │   └── ConfigDTO          // 配置数据传输对象
│   │
│   ├── exception              // 异常处理
│   │   └── GlobalExceptionHandler // 全局异常处理
│   │
│   └── config                 // Web 配置文件（如 Spring 配置）
│
├── common
│   ├── utils                  // 公共工具类
│   │   ├── JsonUtils          // JSON 处理工具
│   │   └── StringUtils        // 字符串处理工具
│   │
│   ├── constants              // 常量类
│   │   └── ServiceConstant    // 服务相关常量
│   │
│   ├── exceptions             // 公共异常
│   │   └── ServiceException   // 自定义异常类
│   │
│   └── logger                 // 日志模块
│       └── LoggerFactory      // 日志工厂类，管理日志配置
│
└── client
├── discovery              // 客户端服务发现模块
├── config                 // 客户端配置获取模块
└── health                 // 客户端健康检查模块
