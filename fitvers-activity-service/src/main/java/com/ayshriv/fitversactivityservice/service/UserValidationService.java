package com.ayshriv.fitversactivityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class UserValidationService {

    @Autowired
    private WebClient userServiceWebClient;

    public boolean validateUser(String userId) {
        try {

            return userServiceWebClient
                .post()
                .uri("/api/users/validate/" + userId)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        }
        catch (WebClientResponseException e) {
            if (e.getStatusCode()== HttpStatus.NOT_FOUND)
            {
                throw new RuntimeException("User not found: "+ userId);
            } else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new RuntimeException("Invalid user ID: " + userId);
            } else {
                throw new RuntimeException("Error validating user: " + e.getMessage());
            }
        }
    }
}
