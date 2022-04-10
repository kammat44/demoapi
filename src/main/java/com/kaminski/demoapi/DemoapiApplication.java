package com.kaminski.demoapi;

import com.google.gson.Gson;
import com.kaminski.demoapi.model.Base;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

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

//	public static void main(String[] args) throws IOException {
//		String urlString = "https://api.frankfurter.app/1999-02-21?to=USD";
//		URL url = new URL(urlString);
//		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//		Base base = new Gson().fromJson(br.readLine(), Base.class);
////        rateDate=base.getDate();
//        Float usd=base.getRates().getUSD();
//		System.out.print(usd);
////        this.base=base;
//	}
}
