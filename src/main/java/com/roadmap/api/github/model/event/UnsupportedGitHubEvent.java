package com.roadmap.api.github.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.roadmap.api.github.model.GitHubAction;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsupportedGitHubEvent extends GitHubAction {
}
