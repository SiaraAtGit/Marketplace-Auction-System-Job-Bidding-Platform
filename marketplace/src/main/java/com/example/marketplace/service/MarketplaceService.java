package com.example.marketplace.service;

import com.example.marketplace.dto.JobDto;
import com.example.marketplace.model.Bid;
import com.example.marketplace.model.Job;
import com.example.marketplace.repository.BidRepository;
import com.example.marketplace.repository.JobRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class MarketplaceService {

    private final JobRepository jobRepository;
    private final BidRepository bidRepository;

    public MarketplaceService(JobRepository jobRepository, BidRepository bidRepository) {
        this.jobRepository = jobRepository;
        this.bidRepository = bidRepository;
    }

    // Create a new job
    public Job createJob(JobDto dto) {
        Job job = new Job();
        job.setDescription(dto.getDescription());
        job.setRequirements(dto.getRequirements());
        job.setPosterName(dto.getPosterName());
        job.setPosterContact(dto.getPosterContact());
        job.setCreatedAt(LocalDateTime.now());
        job.setExpiresAt(dto.getExpiresAt());
        return jobRepository.save(job);
    }

    public List<Job> getRecentJobs() {
        return jobRepository.findTop10ByOrderByCreatedAtDesc();
    }

    // ✅ active = not expired
    public List<Job> getTopActiveJobs() {
        return jobRepository.findTop10ActiveByMostBids(LocalDateTime.now());
    }

    public Optional<Job> getJob(Long id) {
        return jobRepository.findById(id);
    }

    /** Place a bid only if auction is still open */
    @Transactional
    public Bid placeBid(Long jobId, Bid bid2) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));
        if (job.getExpiresAt() != null && LocalDateTime.now().isAfter(job.getExpiresAt())) {
            throw new IllegalStateException("Auction expired");
        }
        Bid bid = new Bid();
        bid.setBidderName(bid2.getBidderName());
        bid.setAmount(bid2.getAmount());
        bid.setCreatedAt(LocalDateTime.now());
        bid.setJob(job);
        Bid saved = bidRepository.save(bid);
        job.getBids().add(saved);
        return saved;
    }

    /** Lowest bid helper */
    public BigDecimal getLowestBidAmount(Job job) {
        return job.getBids().stream()
                .map(Bid::getAmount)
                .min(Comparator.naturalOrder())
                .orElse(null);
    }

    // 🔑 NEW: assign winner automatically
   @Transactional
public void closeExpiredAuctions() {
    List<Job> expired = jobRepository.findExpiredWithoutWinner(LocalDateTime.now());
    for (Job job : expired) {
        job.getBids().stream()
           .min(Comparator.comparing(Bid::getAmount))
           .ifPresent(bid -> job.setWinnerBid(bid));  // ✅ lambda instead of method ref
    }
}


    /** Optional scheduled task to run every minute */
    @Scheduled(fixedRate = 60000)
    public void autoCloseAuctions() {
        closeExpiredAuctions();
    }
    
}
