package com.gdu.rest.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/*
	@MapperScan
	@Mapper로 등록된 인터페이스를 bean으로 등록할 수 있도록
	@Mapper의 위치를 알려주는 애너테이션
*/
@MapperScan(basePackages = {"com.gdu.rest.mapper"})

@PropertySource(value = {"classpath:application.properties"})
@EnableTransactionManagement
@Configuration
public class DBConfig {
	
	// db.properties 파일을 읽어서 변수에 저장하기
	// ${프로퍼티명}
	@Value(value = "${spring.datasource.driver-class-name}") 
	private String driverClassName;
	
	@Value(value = "${spring.datasource.hikari.jdbc-url}")
	private String jdbcUrl;
	
	@Value(value = "${spring.datasource.hikari.username}")
	private String username;
	
	@Value(value = "${spring.datasource.hikari.password}")
	private String password;
	
	@Value(value = "${mybatis.config-location}")
	private String configLocation;
	
	@Value(value = "${mybatis.mapper-locations}")
	private String mapperLocations;
	
	// HikariConfig
	@Bean
	public HikariConfig config() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClassName);
		config.setJdbcUrl(jdbcUrl);
		config.setUsername(username);
		config.setPassword(password);
		return config;
	}
	
	// HikariDataSource
	@Bean(destroyMethod = "close")
	public HikariDataSource dataSource() {
		return new HikariDataSource(config());
	}
	
	// SqlSessionFactory
	@Bean
	public SqlSessionFactory factory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLocation));
		return bean.getObject();
	}
	
	// SqlSessionTemplate
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(factory());
	}
	
	// 트랜잭션 처리를 위한 TransactionManager를 Bean으로 등록한다.
	@Bean
	public TransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
