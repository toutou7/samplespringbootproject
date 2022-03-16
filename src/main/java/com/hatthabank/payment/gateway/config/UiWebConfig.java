package com.hatthabank.payment.gateway.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class UiWebConfig implements WebMvcConfigurer{

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Override
	public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index");
		registry.addViewController("/index");
		registry.addViewController("/login");
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler(
				"/resources/**",
				"/webjars/**",
				"/img/**",
				"/css/**",
				"/js/**")
		.addResourceLocations(
				"/resources/",
				"classpath:/META-INF/resources/webjars/",
				"classpath:/static/img/",
				"classpath:/static/css/",
				"classpath:/static/js/");
	}

	@Bean
	WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
		return (factory) -> factory.setRegisterDefaultServlet(true);
	}

}
