package com.web.albajob.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.web.albajob.util.AuthCodeGenerator;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
//@ComponentScan(basePackages = {"com.web.albajob.service"})
//@MapperScan(basePackages = {"com.web.albajob"})
@EnableTransactionManagement
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
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
	
	 @Bean
	 public AuthCodeGenerator authCodeGenerator() {
	     return new AuthCodeGenerator();
	 }
	 
	 @Bean
	 public JavaMailSender mailSender() { // 이메일 확인 또는 아이디 비밀번호 찾기시 이용할 객체 리턴 메서드
		 JavaMailSenderImpl mailSender = new JavaMailSenderImpl(); // 객체 생성
		 mailSender.setHost("smtp.gmail.com"); // 이메일 전송에 사용될 smtp 호스트 설정
		 mailSender.setPort(587); // 포트 설정
		 mailSender.setUsername("wjdalsqaaz123@gmail.com"); // 사용될 이메일
		 mailSender.setPassword("lmob akef narj lhcu"); // 생성한 앱 비밀번호 입력.
		 
		 Properties javaMailProperties = new Properties(); // JavaMail 속성 설정을 위한 객체 생성
		 javaMailProperties.put("mail.tranport.protocl", "smtp"); // smtp를 프로토콜로 사용
		 javaMailProperties.put("mail.smtp.auth", "true"); // smtp 서버에 인증 필요
		 javaMailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL 소켓 팩토리 클래스 사용
		 javaMailProperties.put("mail.smtp.starttls.enable", "true"); // STARTTLS(TLS를 시작하는 명령)를 사용하여 암호화된 통신을 활성화
		 javaMailProperties.put("mail.debug", "true"); // 디버깅 출력
		 javaMailProperties.put("mail.smtp.ssl.trust", "smtp.naver.com"); //smtp 서버의 ssl 인증서를 신뢰
		 javaMailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2"); //사용할 ssl 프로토콜 버전
		  
		 mailSender.setJavaMailProperties(javaMailProperties); // 이메일을 보낼 객체에 properties 세팅   
		 return mailSender;
	 }
	 
 	 @Bean
 	 public SqlSessionFactory sqlSessionFactory() throws Exception { 
 		 SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
 		 sqlSessionFactoryBean.setDataSource(dataSource());
 		 return (SqlSessionFactory) sqlSessionFactoryBean.getObject();
 	 }
 	 
 	@Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler(); // 또는 사용할 TaskScheduler 구현체를 반환
    }
 	
 	
}





