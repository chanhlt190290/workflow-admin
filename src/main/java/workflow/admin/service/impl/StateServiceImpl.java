package workflow.admin.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import workflow.admin.model.State;
import workflow.admin.service.StateService;

@Service
@Transactional
public class StateServiceImpl implements StateService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<State> findByProcess(long processId) {
        return em.createQuery("select s from State s where s.processId = :processId", State.class)
                .setParameter("processId", processId).getResultList();
    }

}