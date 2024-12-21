package com.example.CarrerLink_backend.controller;


import com.example.CarrerLink_backend.dto.JobgetResponseDTO;
import com.example.CarrerLink_backend.service.JobService;
import com.example.CarrerLink_backend.utill.StandardResponse;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/jobs")
@AllArgsConstructor
public class JobController {

private final JobService jobService;

    @Operation(
            summary = "Get all jobs",
            description = "Fetch all jobs with optional filters job type,rate and company."
    )
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",description = "Successfully fetched all jobs"),
            @ApiResponse(responseCode = "400",description = "Invalid path parameters"),
            @ApiResponse(responseCode = "500",description = "Internal server error")
    })
    @GetMapping("/{jobType}/{company}")
    public ResponseEntity<StandardResponse> getJobs(
            @PathVariable(required = false) String jobType,
            @PathVariable(required = false) String company
    ){
        List<JobgetResponseDTO> jobs = jobService.getJobs(jobType,company);
        return ResponseEntity.ok(new StandardResponse(true,"Jobs fetched successfully",jobs));
    }


    @Operation(
            summary = "Get all jobs",
            description = "Fetch all jobs with optional filters job type,rate and company."
    )
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",description = "Successfully fetched all jobs"),
            @ApiResponse(responseCode = "400",description = "Invalid path parameters"),
            @ApiResponse(responseCode = "500",description = "Internal server error")
    })
    @GetMapping()
    public ResponseEntity<StandardResponse> getJobs(){
        List<JobgetResponseDTO> jobs = jobService.getJobs();
        return ResponseEntity.ok(new StandardResponse(true,"Jobs fetched successfully",jobs));
    }




}
