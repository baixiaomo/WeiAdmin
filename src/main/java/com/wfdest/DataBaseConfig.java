package com.wfdest;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by feiwei on 2017/7/7.
 */
@Configuration
public class DataBaseConfig {
    private static Logger LOG = Logger.getLogger(DataBaseConfig.class);
    @Resource
    private Environment env;

    /**
     * 声明数据源实例
     * @return
     */
    @Bean
    public DataSource dataSource(){
        LOG.info("------------------初始化数据源-------------------");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName(env.getProperty("spring.datasource.name")); // 数据库名
        dataSource.setUrl(env.getProperty("spring.datasource.url")); // 数据库
        dataSource.setUsername(env.getProperty("spring.datasource.username")); // 用户名
        dataSource.setPassword(env.getProperty("spring.datasource.password")); // 密码
        return dataSource;
    }
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }
}
