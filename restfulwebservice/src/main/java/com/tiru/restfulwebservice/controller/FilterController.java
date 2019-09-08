package com.tiru.restfulwebservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	//field1,field2
	@GetMapping("/filtering")
	public MappingJacksonValue retriveSomeBean() {
		SomeBean someBean=new SomeBean("field1","field2","filed3");
		SimpleBeanPropertyFilter filter= 
				SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider  filters =new SimpleFilterProvider()
				.addFilter("someBeanFilter", filter);

		MappingJacksonValue mapping =new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
		
	}
	@GetMapping("/filtering-list")
	public MappingJacksonValue retriveListOfSomeBean() {
		List<SomeBean> list=Arrays.asList(new SomeBean("field1","field2","filed3"),new SomeBean("field1","field2","filed3"));
		SimpleBeanPropertyFilter filter= 
				SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider  filters =new SimpleFilterProvider()
				.addFilter("someBeanFilter", filter);

		MappingJacksonValue mapping =new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
		
	}
}
