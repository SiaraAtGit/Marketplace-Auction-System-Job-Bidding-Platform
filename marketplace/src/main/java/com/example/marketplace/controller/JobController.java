package com.example.marketplace.controller;

import com.example.marketplace.dto.JobDto;
import com.example.marketplace.model.Job;
import com.example.marketplace.service.MarketplaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final MarketplaceService service;

    public JobController(MarketplaceService service) { 
        this.service = service; 
    }

    @GetMapping("/recent")
    public List<Job> recent() { 
        return service.getRecentJobs(); 
    }

    @GetMapping("/active")
    public List<Job> active() { 
        return service.getTopActiveJobs(); 
    }

    // ✅ Accept JobDto from API
    @PostMapping
    public Job create(@RequestBody JobDto dto) { 
        return service.createJob(dto); 
    }

    @GetMapping("/{id}")
    public Job get(@PathVariable Long id) { 
        return service.getJob(id)
                .orElseThrow(() -> new IllegalArgumentException("Job not found")); 
    }
}
