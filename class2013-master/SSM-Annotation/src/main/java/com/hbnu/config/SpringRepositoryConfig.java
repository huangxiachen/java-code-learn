package com.hbnu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

/**
 * @author chendikai
 * @date 2023-04-11 8:39
 */
@Configuration
@MapperScan("com.hbnu.dao")
public class SpringRepositoryConfig {

    @Bean(value = "dataSource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/class2013?serverTimezone=GMT&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("chendikai");

        return dataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory newSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        factoryBean.setDataSource(dataSource);

        return factoryBean.getObject();
    }

}
