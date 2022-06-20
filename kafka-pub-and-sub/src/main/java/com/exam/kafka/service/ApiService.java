package com.exam.kafka.service;

import com.exam.kafka.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@Slf4j
public class ApiService {
    @Autowired
    private ObjectMapper objectMapper;

    private RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

    private HttpEntity<?> getEntity(Object params) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-type", org.springframework.http.MediaType.APPLICATION_JSON_VALUE);
        return params != null ? new HttpEntity<>(params, httpHeaders) : new HttpEntity<>(httpHeaders);
    }

    private <T> T execute(URI uri, HttpMethod method, Object params, Class<T> clazz) {
        try {
            return restTemplate.exchange(uri, method, getEntity(params), clazz).getBody();
        } catch (Exception exception) {
            try {
                String json = objectMapper.writeValueAsString(params);
                log.error("errors on api: {}, request params: {}", uri, json, exception);
            }
            catch(JsonProcessingException je) {
                log.error("errors on api: {}, parsing error params: {}", params, je, exception);
            }

            return null;
        }
    }

    public User calAvg(User user) {
        String url = "http://localhost:8083/cal/avg";

        User response = execute(URI.create(url), HttpMethod.POST, user, User.class);

        if (response == null) {
            return null;
        }

        return response;
    }
}
