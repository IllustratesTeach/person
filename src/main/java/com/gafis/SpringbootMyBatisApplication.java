package com.gafis;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

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
