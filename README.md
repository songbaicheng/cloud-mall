# 云商城系统（cloud-mall）
## Spring Cloud Alibaba依赖选用
 | 组件或框架 | 版本号 |
|-------|--------|
| Spring Cloud Alibaba | 2022.0.0.0-RC2 |
| Spring Cloud | 2022.0.0 |
| Spring Boot | 3.0.2 |
| Sentinel | 1.8.6 |
| Nacos | 2.2.1 |
| RocketMQ | 4.9.4 |
| Seata | 1.7.0-native-rc2 |

## 服务模块
- mall-dependency：项目版本统一管理模块
- mall-admin：商城服务监控模块
- mall-gateway：商城网关模块
- mall-common：公用模块
   - general-elements：公用元素模块
   - redis-lettuce：redis 工具模块
- mall-mpg：mybaits-plus代码生成器
- mall-auth: 商城统一认证模块
- mall-web：商城后台服务模块

### 模块介绍