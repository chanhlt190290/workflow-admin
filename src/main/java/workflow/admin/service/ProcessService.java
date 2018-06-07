/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.admin.service;

import java.util.List;
import workflow.admin.model.Process;

/**
 *
 * @author trungchanh
 */
public interface ProcessService {

    Process get(long processId);
    List<Process> getAll(int page, int count);
	Process create(String name, long createdBy, String description);
	Process update(long processId, String name, long updatedBy, String description);
}
