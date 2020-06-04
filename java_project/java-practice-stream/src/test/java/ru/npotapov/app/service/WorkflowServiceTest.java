package ru.npotapov.app.service;

import org.junit.Before;
import org.junit.Test;
import ru.npotapov.app.model.Workflow;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WorkflowServiceTest {

    private WorkflowService workflowService;

    @Before
    public void setUp() {
        Workflow wf1 = new Workflow.Builder(1,"wf_1").build();
        Workflow wf2 = new Workflow.Builder(2,"wf_2").build();
        Workflow wf3 = new Workflow.Builder(3,"wf_3").build();
        Workflow wf4 = new Workflow.Builder(4,"wf_4").build();
        List<Workflow> workflowList = new ArrayList<>();
        workflowList.add(wf1);
        workflowList.add(wf1);
        workflowList.add(wf1);
        workflowList.add(wf1);
        workflowService = new WorkflowService(workflowList);
    }

    @Test
    public void getWorkflows() {
        assertEquals(4,workflowService.getWorkflows().size());
    }

    @Test
    public void createWorkflow() {
        workflowService.createWorkflow(5,"wf_4");
        assertEquals(5,workflowService.getWorkflows().size());
    }

    @Test
    public void createWorkflowIsSucceed() {
        assertTrue(workflowService.createWorkflow(5,"wf_4"));
    }
}