package com.icho.springsource.profilesTest;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * @Author: icho
 * @Date: 2022/6/15 10:18
 * @Describe:
 */
@Configuration
@PropertySource(value = "classpath:ds.properties")
public class MainConfig implements EmbeddedValueResolverAware { // 内嵌的值解析器,解析表达式

    @Value("${ds.username}")
    private String userName;

    @Value("${ds.password}")
    private String password;

    //@Value("${ds.jdbcUrl}")
    private String jdbcUrl;

    //@Value("${ds.classDriver}")
    private String classDriver;

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.jdbcUrl = resolver.resolveStringValue("${ds.jdbcUrl}");
        this.classDriver = resolver.resolveStringValue("${ds.classDriver}");
    }

    @Bean
    @Profile(value = "test")
    public DataSource testDs() {
        return buildDataSource(new DruidDataSource());
    }

    @Bean
    @Profile(value = "dev")
    public DataSource devDs() {
        return buildDataSource(new DruidDataSource());
    }

    @Bean
    @Profile(value = "prod")
    public DataSource prodDs() {
        return buildDataSource(new DruidDataSource());
    }

    private DataSource buildDataSource(DruidDataSource dataSource) {
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(classDriver);
        dataSource.setUrl(jdbcUrl);
        return dataSource;
    }
}
