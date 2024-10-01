package com.roadmap.api.github.command;

import com.roadmap.api.github.model.GitHubAction;
import com.roadmap.api.github.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.web.client.HttpClientErrorException;
import java.util.List;

@ShellComponent
public class ActivityCommand {

    private final ActionService actionService;

    @Autowired
    public ActivityCommand(ActionService actionService) {
        this.actionService = actionService;
    }

    @ShellMethod(key = "github-activity", value = "Get GitHub activity for a given user")
    public String getActions(String username) {

        List<GitHubAction> actions;

        try {
            actions = actionService.getActions(username);
        } catch (HttpClientErrorException e) {
            return "Error: " + username + " was not founded";
        } catch (Exception e) {
            return "Error: Try later";
        }

        return actionsToString(username, actions);
    }

    @ShellMethod(key = "github-activity-limit", value = "Get GitHub activity for a given user with a limit of events")
    public String getActionsWithLimit(String username, String limitString) {

        int limit;
        if (limitString == null) return "Error: Limit is required";

        try {
            limit = Integer.parseInt(limitString);
        } catch (NumberFormatException e) {
            return "Error: Limit must be a valid integer";
        }

        if (username == null) return "Error: Username is required";
        if (limit <= 0) return "Error: Limit must be a positive integer";
        if (limit > 100) return "Error: Limit must be less than or equal to 100";

        List<GitHubAction> actions;

        try {
            actions = actionService.getActionsWithLimit(username, limit);
        } catch (HttpClientErrorException e) {
            return "Error: " + username + " was not founded";
        } catch (Exception e) {
            return "Error: Try later";
        }

        return actionsToString(username, actions);
    }

    private String actionsToString(String username, List<GitHubAction> actions) {

        if (actions.isEmpty()) return "No activity found for user " + username;

        StringBuilder output = new StringBuilder("output:\n");

        for (GitHubAction action : actions) {
            output.append("- ").append(action.toString()).append("\n");
        }

        return output.toString();
    }

}
