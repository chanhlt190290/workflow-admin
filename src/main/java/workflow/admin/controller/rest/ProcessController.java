/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.admin.controller.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import workflow.admin.exception.ResourceNotFoundException;
import workflow.admin.model.ApiResponse;
import workflow.admin.service.ProcessService;
import workflow.admin.service.StateService;
import workflow.admin.service.TransitionService;
import workflow.admin.model.Process;
import workflow.admin.model.State;
import workflow.admin.model.Transition;

/**
 *
 * @author trungchanh
 */
@RestController
@RequestMapping("/api/v1")
public class ProcessController {

    @Autowired
    ProcessService processService;

    @Autowired
    StateService stateService;

    @Autowired
    TransitionService transitionService;

    @PostMapping(value = "/processes")
    public ResponseEntity<ApiResponse> addProcess(@RequestParam("name") String name,
            @RequestParam("createdBy") long createdBy,
            @RequestParam(name = "description", required = false) String description) {
        Process process = processService.create(name, createdBy, description);
        ApiResponse apiResponse = new ApiResponse(process);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/processes/{processId}")
    public ResponseEntity<ApiResponse> getProcess(@PathVariable("processId") long processId) {
        Process process = processService.get(processId);
        if (process == null) {
            throw new ResourceNotFoundException("process", "id", processId);
        }
        ApiResponse apiResponse = new ApiResponse(process);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/processes/{processId}/states")
    public ResponseEntity<ApiResponse> getStates(@PathVariable("processId") long processId) {
        Process process = processService.get(processId);
        if (process == null) {
            throw new ResourceNotFoundException("process", "id", processId);
        }
        List<State> states = stateService.findByProcess(processId);
        ApiResponse apiResponse = new ApiResponse(states);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/processes/{processId}/transitions")
    public ResponseEntity<ApiResponse> getTransitions(@PathVariable("processId") long processId) {
        Process process = processService.get(processId);
        if (process == null) {
            throw new ResourceNotFoundException("process", "id", processId);
        }
        List<Transition> transitions = transitionService.findByProcess(processId);
        ApiResponse apiResponse = new ApiResponse(transitions);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/processes/{processId}")
    public ResponseEntity<ApiResponse> updateProcess(@PathVariable("processId") long processId,
            @RequestParam(name = "name", required = false) String name, @RequestParam("updatedBy") long updatedBy,
            @RequestParam(name = "description", required = false) String description) {
        Process process = processService.get(processId);
        if (process == null) {
            throw new ResourceNotFoundException("process", "id", processId);
        }
        process = processService.update(processId, name, updatedBy, description);
        ApiResponse apiResponse = new ApiResponse(process);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/processes")
    public ResponseEntity<ApiResponse> getProcesses(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "count", required = false, defaultValue = "20") int count) {
        List<Process> processes = processService.getAll(page, count);
        ApiResponse apiResponse = new ApiResponse(processes);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
