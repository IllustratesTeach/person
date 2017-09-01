package com.gafis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan
@MapperScan("com.gafis.mapper")
public class SpringbootMyBatisApplication {



	//DataSource配置
    @Bean
    @ConfigurationProperties(prefix="spring.data")
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }

	
	public static void main(String[] args) {
		 new SpringApplicationBuilder(SpringbootMyBatisApplication.class).web(true).run(args);
	}
}
