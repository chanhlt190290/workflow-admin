package workflow.admin.service;

import java.util.List;

import workflow.admin.model.State;

public interface StateService{
    List<State> findByProcess(long processId);
}