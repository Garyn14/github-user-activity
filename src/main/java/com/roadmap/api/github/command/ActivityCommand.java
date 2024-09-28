package com.roadmap.api.github.command;

import com.roadmap.api.github.model.Activity;
import com.roadmap.api.github.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class ActivityCommand {

    private final ActivityService activityService;

    @Autowired
    public ActivityCommand(ActivityService activityService) {
        this.activityService = activityService;
    }

    @ShellMethod(key = "activity", value = "Activity Service")
    public List<Activity> getActivity() {
        return activityService.getActivity();
    }

}
