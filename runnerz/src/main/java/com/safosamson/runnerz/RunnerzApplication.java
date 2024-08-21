package com.safosamson.runnerz;

import com.safosamson.runnerz.run.Location;
import com.safosamson.runnerz.run.Run;
import com.safosamson.runnerz.user.UserHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.LocalDateTime;

@SpringBootApplication
public class RunnerzApplication {

	public static void main(String[] args) {SpringApplication.run(RunnerzApplication.class, args);}

	// this method creates a UserHttpClient bean that will be used to make HTTP requests to the JSONPlaceholder API
	@Bean
	UserHttpClient userHttpClient(){
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHttpClient.class);
	}


}
