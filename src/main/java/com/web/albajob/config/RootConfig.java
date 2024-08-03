package com.web.albajob.config;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
//@ComponentScan(basePackages = {"com.web.albajob.service"})
//@MapperScan(basePackages = {"com.web.albajob"})
@EnableTransactionManagement
public class RootConfig {
	
	@Bean
	public DataSource datasource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		config.setJdbcUrl("jdbc:mysql://mysql-aws.c1asumy42bvk.ap-northeast-2.rds.amazonaws.com:3306/mysqlaws");
		config.setUsername("mysqlaws");
		config.setPassword("vbNLusEj1PUS7Mw2J77t");
		
		config.setMaximumPoolSize(10);
		config.setConnectionTimeout(30000);
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}
}
