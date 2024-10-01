package com.roadmap.api.github.service;

import com.roadmap.api.github.model.GitHubAction;
import com.roadmap.api.github.model.event.UnsupportedGitHubEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {
    private static final String URL = "https://api.github.com/users/";
    private final RestTemplate restTemplate;

    @Autowired
    public ActionServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<GitHubAction> getActions(String  username) {

        GitHubAction[] actionsArray = restTemplate
                .getForObject(URL + username + "/events", GitHubAction[].class);

        if (actionsArray == null) return Collections.emptyList();

        return Arrays.stream(actionsArray)
                .filter(a -> !(a  instanceof UnsupportedGitHubEvent)) // avoid unsupported GitHubEvents
                .toList();
    }

}
