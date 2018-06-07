package workflow.admin.service;

import java.util.List;
import workflow.admin.model.Action;

public interface ActionService {

    Action get(int id);

    Action create(Action action);

    public Action addTargets(int actionId, List<Integer> targetIds);

}
