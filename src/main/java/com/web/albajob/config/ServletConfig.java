package com.web.albajob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration 
@EnableWebMvc 
@EnableScheduling 
@ComponentScan(basePackages = {"com.web.albajob"}) 
public class ServletConfig implements WebMvcConfigurer{

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		
	   InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	   viewResolver.setPrefix("/WEB-INF/views/");
	   viewResolver.setSuffix(".jsp");
	   registry.viewResolver(viewResolver);
	}
	
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {

	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	 }
	 
	 @Bean
	 public String uploadPath() {
		 return "C:\\upload\\albajob";
	 }
	 
	 @Bean
	 public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	
	    resolver.setMaxUploadSize(31457280);
	    
	    resolver.setMaxUploadSizePerFile(10485760);
	    resolver.setDefaultEncoding("UTF-8");
	      
	    return resolver;
	 }	 
}
