package com.kaminski.demoapi;

import com.google.gson.Gson;
import com.kaminski.demoapi.model.Base;
import com.kaminski.demoapi.model.RateSearch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class DemoapiApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DemoapiApplication.class, args);
	}


	@Bean
	Validator validator(){
		return new LocalValidatorFactoryBean();
	}

	@Override
	public void configureValidatingRepositoryEventListener(final ValidatingRepositoryEventListener validatingListener) {
		validatingListener.addValidator("beforeCreate", validator());
		validatingListener.addValidator("beforeCreate", validator());

	}

	@PostMapping(
			path = "/ratesearch",
			consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseEntity<String> handleNonBrowserSubmissions(@RequestBody RateSearch ratesearch) throws Exception {
		Float usdRate = ratesearch.checkUSDvalue(ratesearch.getRateDate());
		ratesearch.setUsd(usdRate);
		return new ResponseEntity<String>("Thank you for submitting feedback", HttpStatus.OK);
	}
}
