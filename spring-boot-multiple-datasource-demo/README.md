# Spring Boot Multiple DataSource Demo

This is a spring boot project, in which I config two `DataSource` bean.

## How & Note

### Step 1: 关闭自动配置

在使用 Spring Boot 自动配置的情况下，如果显式配置了 `DataSource`，Spring Boot 不再创建 `DataSource` 的另一个实例。
为了在工程中配置多个数据源，需要关闭 Spring Boot 相关的自动配置，然后显式地配置多个 `DataSource`。相关的配置如下代码所示。

```java
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class})
```

### Step 2: 分离不同的数据源配置

在使用 Spring Boot 自动配置和 H2 的时候，Spring Boot 会使用默认的配置，如 `url`，`username` 等。
但是关闭 Spring Boot 相关的自动配置之后，Spring Boot 不再使用默认的配置，所以我们需要自己配置这些参数。
另外，不同数据源的配置应当分离。具体配置参考 `resources/application.properties`。

### Step 3: 显式配置 DataSource

参见 `SpringBootMultipleDatasourceDemoApplication.java`。

### Step 4: 测试

参见测试类。