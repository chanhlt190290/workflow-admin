/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.admin.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import workflow.admin.model.Action;
import workflow.admin.model.Activity;
import workflow.admin.model.Transition;
import workflow.admin.service.TransitionService;

/**
 *
 * @author trungchanh
 */
@Service
@Transactional
public class TransitionSeviceImpl implements TransitionService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Transition create(Transition transition) {
        em.persist(transition);
        return transition;
    }

    @Override
    public Transition addActions(int transitionId, List<Integer> actionIds) {
        Transition transition = em.find(Transition.class, transitionId);
        for (Integer actionId : actionIds) {
            Action action = em.find(Action.class, actionId);
            transition.getActions().add(action);
        }
        em.flush();
        return transition;
    }

    @Override
    public Transition addActivities(int transitionId, List<Integer> activityIds) {
        Transition transition = em.find(Transition.class, transitionId);
        for (Integer activityId : activityIds) {
            Activity activity = em.find(Activity.class, activityId);
            transition.getActivities().add(activity);
        }
        em.flush();
        return transition;
    }

}
