/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.admin.controller.rest;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workflow.admin.model.Action;
import workflow.admin.model.ApiResponse;
import workflow.admin.service.ActionService;

/**
 *
 * @author trungchanh
 */
@RestController
@RequestMapping("/api/v1")
public class ActionController {

    @Autowired
    ActionService actionService;

    @PostMapping(value = "/actions", consumes = "application/json")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody Action action) {
        action = actionService.create(action);
        ApiResponse apiResponse = new ApiResponse(action);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    
    @PostMapping(value = "/actions/{actionId}/targets", consumes = "application/json")
    public ResponseEntity<ApiResponse> addTargets(@PathVariable("actionId") int actionId, @Valid @RequestBody List<Integer> targetIds) {
        Action action = actionService.addTargets(actionId, targetIds);
        ApiResponse apiResponse = new ApiResponse(action);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}