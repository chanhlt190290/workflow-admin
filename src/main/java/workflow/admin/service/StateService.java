/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.admin.service;

import java.util.List;
import workflow.admin.model.State;

/**
 *
 * @author trungchanh
 */
public interface StateService {

    State create(State state);

    public State addActivities(int stateId, List<Integer> activityIds);
}