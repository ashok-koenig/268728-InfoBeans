package com.example.enrollment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CatalogueClient {
    private final RestClient restClient;

    public CatalogueClient(@Value("${catalogue.url}") String url) {
        this.restClient = RestClient.builder().baseUrl(url).build();
    }

    public Course find(String courseId){
        return restClient.get().uri("/courses/{id}", courseId).retrieve().body(Course.class);
    }
}
