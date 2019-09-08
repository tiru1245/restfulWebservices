package com.tiru.restfulwebservice;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class RestfulwebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulwebserviceApplication.class, args);
	}
	@Bean
   public LocaleResolver localResolver() {
	   AcceptHeaderLocaleResolver  localResolver =new AcceptHeaderLocaleResolver();
	   localResolver.setDefaultLocale(Locale.US);
	   return localResolver;
   }
	
	
}
