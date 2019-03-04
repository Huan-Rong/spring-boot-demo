# Spring Boot Druid Demo

This is a spring boot project, which shows how to config and use Alibaba Druid.

## How & Note

### Step 1: remove HikariCP dependency

In Spring Boot 2.x, HikariCP is the default connection pool.
Before using Alibaba Druid, You need to remove HikariCP dependency in the pom.xml.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
    <exclusions>
        <exclusion>
            <groupId>com.zaxxer</groupId>
            <artifactId>HikariCP</artifactId> 
        </exclusion>
    </exclusions>
</dependency>
```

### Step 2: add in Druid dependency

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.1.10</version>
</dependency>
```

### Step 3: config Druid

By Default, Spring Boot 2.x use and autoconfig HikariCP,
including connection pool parameters.

But you would config Druid by yourself when using Druid instead of HikariCP,
or everything like **PoolingCount**,**CreateCount** and **ConnectionCount** would be 0.

Look `resources/application.properties` for details.

### Step 4: config Filter

Druid allows us to customize behaviors for connection, 
for instance, behaviors before or after connection.
It's an optional and easy operation, everything you need to do 
is to extend `FilterEventAdapter` and a configuration file named `META-INF/druid-filters.properties`。