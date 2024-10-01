package com.roadmap.api.github.command;

import com.roadmap.api.github.model.GitHubAction;
import com.roadmap.api.github.service.ActionService;
import com.roadmap.api.github.service.ActionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class ActivityCommand {

    private final ActionService actionService;

    @Autowired
    public ActivityCommand(ActionService actionService) {
        this.actionService = actionService;
    }

    @ShellMethod(key = "activity", value = "Activity Service")
    public List<GitHubAction> getActivity(String username) {
        return actionService.getActions(username);
    }

}
