package com.roadmap.api.github.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActivityService {
    private static final String URL = "https://api.github.com/users/";
    private final RestTemplate restTemplate;

    @Autowired
    public ActivityService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getActivity() {
        return restTemplate.getForObject(URL + "Garyn14/events", String.class);
    }
}
