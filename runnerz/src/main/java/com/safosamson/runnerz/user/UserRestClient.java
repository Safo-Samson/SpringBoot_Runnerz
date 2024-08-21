package com.safosamson.runnerz.user;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component // this tells Spring to create an instance of this class when the application starts
public class UserRestClient {
    private final RestClient restClient;

    public UserRestClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public List<User> findAll(){
        return restClient
                .get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});

    }

    public User findById(int id){
        return restClient
                .get()
                .uri("/users/{id}", id)
                .retrieve()
                .body(User.class);
    }
}
