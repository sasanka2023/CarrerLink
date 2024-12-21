package com.example.CarrerLink_backend.service;

import com.example.CarrerLink_backend.dto.JobgetResponseDTO;

import java.util.List;

public interface JobService {
    List<JobgetResponseDTO> getJobs(String jobType, String company);
    List<JobgetResponseDTO> getJobs();
}
