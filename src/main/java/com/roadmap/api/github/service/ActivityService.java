package com.roadmap.api.github.service;

import com.roadmap.api.github.model.Activity;
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

    @Autowired
    public ActivityService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Activity> getActivity() {
        Activity[] activitiesArray = restTemplate.getForObject(URL + "kamranahmedse/events", Activity[].class);

        if (activitiesArray == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(activitiesArray)
                .filter(a -> a.getType() != null) // delete untracked types
                .toList();
    }
}
