package site.bulibucai.springbootmultipledatasourcedemo; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/** 
 * SpringBootMultipleDatasourceDemoApplication Tester.
 * 手动使用 IntelliJ 插件生成的 UT 类。并没有使用 @SpringBootTest
 *
 *
 * @author <Authors name>
 * @since <pre>Feb 28, 2019</pre>
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SpringBootMultipleDatasourceDemoApplication.class })
public class SpringBootMultipleDatasourceDemoApplicationTest {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    /**
     * 
     * Method: fooDataSourceProperties() 
     * 
     */ 
    @Test
    public void testFooDataSourceProperties() {
        Assert.assertNotNull(dataSourceProperties);
    }

    /** 
     * 
     * Method: fooDataSource() 
     * 
     */ 
    @Test
    public void testFooDataSource() {
        Assert.assertNotNull(dataSource);
    }

    /** 
     * 
     * Method: fooTxManager(DataSource fooDataSource) 
     * 
     */ 
    @Test
    public void testFooTxManager() {
        Assert.assertNotNull(platformTransactionManager);
    }


} 
