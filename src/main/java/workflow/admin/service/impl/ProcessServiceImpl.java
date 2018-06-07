/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.admin.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import workflow.admin.model.Process;
import workflow.admin.service.ProcessService;

/**
 *
 * @author trungchanh
 */
@Service
@Transactional
public class ProcessServiceImpl implements ProcessService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Process get(long processId) {
        return em.find(Process.class, processId);
    }

    @Override
    public List<Process> getAll(int page, int count) {
        int offset = (page - 1) * count;
        TypedQuery<Process> query = em.createQuery("select p from Process p", Process.class);
        query.setFirstResult(offset);
        query.setMaxResults(count);
        return query.getResultList();
    }

    @Override
    public Process update(long processId, String name, long updatedBy, String description) {
        Process process = get(processId);
        if (name != null)
            process.setName(name);
        if (description != null)
            process.setDescription(description);
        process.setUpdatedBy(updatedBy);
        em.flush();
        return process;
    }

    @Override
    public Process create(String name, long createdBy, String description) {
        Process process = new Process();
        process.setName(name);
        process.setCreatedBy(createdBy);
        process.setDescription(description);
        process.setUpdatedBy(createdBy);
        em.persist(process);
        return process;
    }

}
