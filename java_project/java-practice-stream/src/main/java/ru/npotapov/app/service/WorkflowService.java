package ru.npotapov.app.service;

import ru.npotapov.app.model.Task;
import ru.npotapov.app.model.Workflow;

import java.util.ArrayList;
import java.util.List;

public class WorkflowService {
    private List<Workflow> workflows;

    public WorkflowService(List<Workflow> workflows) {
        this.workflows = workflows;
    }

    public WorkflowService() {
        this.workflows = new ArrayList<>();
    }

    public List<Workflow> getWorkflows() {
        return workflows;
    }

    public boolean createWorkflow(long id, String name, List<Task> tasks) {
        workflows.add(new Workflow.Builder(id, name).setTasks(tasks).build());
        return true;
    }

    public boolean createWorkflow(long id, String name) {
        workflows.add(new Workflow.Builder(id, name).build());
        return true;
    }

    public boolean createWorkflow(long id, String name, String description, boolean isEnabled, List<Task> tasks) {
        workflows.add(new Workflow.Builder(id, name).setDescription(description).setIsEnabled(isEnabled).setTasks(tasks).build());
        return true;
    }


}
