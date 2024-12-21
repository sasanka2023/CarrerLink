package com.example.CarrerLink_backend.service.impl;


import com.example.CarrerLink_backend.dto.JobgetResponseDTO;
import com.example.CarrerLink_backend.entity.Job;
import com.example.CarrerLink_backend.repo.JobRepo;
import com.example.CarrerLink_backend.service.JobService;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepo jobRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<JobgetResponseDTO> getJobs(String jobType, String company) {
        List<Job> jobs = jobRepo.findByJobTypeAndCompanyNameEquals(jobType,company);
        return modelMapper.map(jobs,new TypeToken<List<JobgetResponseDTO>>() {}.getType());
    }

    @Override
    public List<JobgetResponseDTO> getJobs() {
        List<Job> jobs = jobRepo.findAll();
        return modelMapper.map(jobs,new TypeToken<List<JobgetResponseDTO>>() {}.getType());
    }
}
