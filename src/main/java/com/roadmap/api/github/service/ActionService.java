package com.roadmap.api.github.service;

import com.roadmap.api.github.model.GitHubAction;

import java.util.List;

public interface ActionService {
    List<GitHubAction> getActions(String username);
}
