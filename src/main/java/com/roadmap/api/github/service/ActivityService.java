package com.roadmap.api.github.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roadmap.api.github.model.GitHubAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ActivityService {
    private static final String URL = "https://api.github.com/users/";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public ActivityService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public List<GitHubAction> getActivities() throws Exception{
        /*Activity[] activitiesArray = restTemplate.getForObject(URL + "kamranahmedse/events", Activity[].class);

        if (activitiesArray == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(activitiesArray)
                .filter(a -> a.getType() != null)  //avoid untracked types
                .map(this::mapActivityType)
                .toList();*/

        GitHubAction[] activitiesArray = restTemplate
                .getForObject(URL + "Garyn14/events", GitHubAction[].class);

        if (activitiesArray == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(activitiesArray)
                //.filter(a -> a.getType() != null)  avoid untracked types
                .toList();
    }

}
