package workflow.admin.service;

import java.util.List;

import workflow.admin.model.Transition;

public interface TransitionService{
    List<Transition> findByProcess(long processId);
}