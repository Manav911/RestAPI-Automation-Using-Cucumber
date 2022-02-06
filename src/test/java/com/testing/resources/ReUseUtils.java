package com.testing.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ReUseUtils  {

	RequestSpecification requestSpecification;
	
	

	public RequestSpecification requestSpecBuilder() throws IOException {
		PrintStream printStream = new PrintStream(new FileOutputStream("log.txt"));
		requestSpecification = new RequestSpecBuilder().setBaseUri(ReUseUtils.getFromGlobalProperties("BaseURI"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(printStream))
				.addFilter(ResponseLoggingFilter.logResponseTo(printStream))
				.setContentType(ContentType.JSON).build();
		return requestSpecification;
	}
	
	public static String getFromGlobalProperties(String key) throws IOException
	{
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream("D:\\RestFulApi_Automation_Testing\\RestAPI-Automation-Using-Cucumber\\src\\test\\java\\com\\testing\\resources\\global.properties");
		properties.load(fileInputStream);
		return (String) properties.get(key);
		
		
	}
}
