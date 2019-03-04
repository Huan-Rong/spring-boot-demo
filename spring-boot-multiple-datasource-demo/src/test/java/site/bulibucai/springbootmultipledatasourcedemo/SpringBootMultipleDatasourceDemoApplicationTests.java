package site.bulibucai.springbootmultipledatasourcedemo;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootMultipleDatasourceDemoApplicationTests {

    @Autowired
    private DataSourceProperties barDataSourceProperties;

    @Autowired
    private DataSource barDataSource;

    @Autowired
    private PlatformTransactionManager barTxManager;

    @Autowired
    private DataSourceProperties fooDataSourceProperties;

    @Autowired
    private DataSource fooDataSource;

    @Autowired
    private PlatformTransactionManager fooTxManager;

    @Test
    public void contextLoads() {
        log.info(barDataSourceProperties.getUrl());
        log.info(fooDataSourceProperties.getUrl());

        Assert.assertNotNull(barDataSourceProperties);
        Assert.assertNotNull(barDataSource);
        Assert.assertNotNull(barTxManager);
        Assert.assertNotNull(fooDataSourceProperties);
        Assert.assertNotNull(fooDataSource);
        Assert.assertNotNull(fooTxManager);
    }

    /**
     * Spring Boot 2.x 默认情况下使用的是 HikariCP
     */
    @Test
    public void testDataSourceType() {
        Assert.assertEquals(HikariDataSource.class, fooDataSource.getClass());
        Assert.assertEquals(HikariDataSource.class, barDataSource.getClass());
    }

}
