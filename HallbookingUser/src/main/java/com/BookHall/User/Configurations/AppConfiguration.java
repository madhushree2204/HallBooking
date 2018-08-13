package com.BookHall.User.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.BookHall")
public class AppConfiguration {

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		   registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	   }
		@Bean
	    public ViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	      // viewResolver.setPrefix("/WEB-INF/");
	        viewResolver.setPrefix("/");
	        viewResolver.setSuffix(".jsp");
	        return viewResolver;
	    }
}
