package ru.npotapov.app;

import ru.npotapov.app.model.Task;
import ru.npotapov.app.model.Workflow;
import ru.npotapov.app.service.WorkflowService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Task> taskList = Arrays.asList(
                new Task.Builder(1, "tsk_1", 1).build(),
                new Task.Builder(2, "tsk_2", 1).build()
        );
//        Task task = new Task.Builder(1, "tsk_1", 1).build();
        WorkflowService workflowService = new WorkflowService();
//        workflowService.createWorkflow(1, "wf_1", List.of(task));
        workflowService.createWorkflow(1, "wf_1", taskList);
        System.out.println(workflowService.getWorkflows().get(0).toString());
    }
}
