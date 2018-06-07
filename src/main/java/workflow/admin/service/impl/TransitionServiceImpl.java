package workflow.admin.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import workflow.admin.model.Transition;
import workflow.admin.service.TransitionService;

@Service
@Transactional
public class TransitionServiceImpl implements TransitionService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Transition> findByProcess(long processId) {
        return em.createQuery("select t from Transition t where t.processId = :processId", Transition.class)
                .setParameter("processId", processId).getResultList();
    }

}