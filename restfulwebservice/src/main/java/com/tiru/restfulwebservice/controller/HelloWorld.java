package com.tiru.restfulwebservice.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tiru.restfulwebservice.beans.HelloWorldBean;

@RestController
public class HelloWorld {

	@Autowired
	private MessageSource messgeSource;

	@GetMapping(path = "/helloworld")
	public String sayHello() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean sayHelloBean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping(path = "/hello-world-bean/{name}")
	public HelloWorldBean sayHelloBeanPathVariable(@Valid @PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	@GetMapping(path = "/hello-world-bean/internalization")
	public String sayHelloInternalization() {
		return messgeSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}
}
