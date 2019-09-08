package com.tiru.restfulwebservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	  public static final Contact DEFAULT_CONTACT = new Contact("tiru", "s", "tiru");

	  public static final  ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome Api Documentation", "Awesome Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());

	private static final Set<String> PRODUCE_AND_CONSUME = new HashSet<String>(Arrays.asList("application/json","application/xml"));

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO).produces(PRODUCE_AND_CONSUME).consumes(PRODUCE_AND_CONSUME);
	}
}
