package com.example.main;

import hello.wsdl.GetCityForecastByZIPResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.example.client.WeatherClient;
import com.example.configuration.WeatherConfiguration;

public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(WeatherConfiguration.class, args);

		WeatherClient weatherClient = ctx.getBean(WeatherClient.class);

		String zipCode = "30341";
		if (args.length > 0) {
			zipCode = args[0];
		}
		GetCityForecastByZIPResponse response = weatherClient.getCityForecastByZip(zipCode);
		weatherClient.printResponse(response);
	}
}