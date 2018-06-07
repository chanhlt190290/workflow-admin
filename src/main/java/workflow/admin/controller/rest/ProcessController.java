/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.admin.controller.rest;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workflow.admin.model.ApiResponse;
import workflow.admin.service.ProcessService;
import workflow.admin.model.Process;

/**
 *
 * @author trungchanh
 */
@RestController
@RequestMapping("/api/v1")
public class ProcessController {

    @Autowired
    ProcessService processService;

    @PostMapping(value = "/processes", consumes = "application/json")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody Process process) {
        process = processService.create(process);
        ApiResponse apiResponse = new ApiResponse(process);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
