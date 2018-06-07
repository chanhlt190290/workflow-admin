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
import workflow.admin.model.Activity;
import workflow.admin.model.Target;
import workflow.admin.service.ActivityService;

/**
 *
 * @author trungchanh
 */
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Activity create(Activity activity) {
        em.persist(activity);
        return activity;
    }

    @Override
    public Activity addTargets(int activityId, List<Integer> targetIds) {
        Activity activity = em.find(Activity.class, activityId);
        for (Integer targetId : targetIds) {
            Target target = em.find(Target.class, targetId);
            activity.getTargets().add(target);
        }
        em.flush();
        return activity;
    }

}
