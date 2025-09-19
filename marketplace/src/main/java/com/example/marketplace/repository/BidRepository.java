package com.example.marketplace.repository;


import com.example.marketplace.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface BidRepository extends JpaRepository<Bid, Long> {
List<Bid> findByJobIdOrderByAmountAsc(Long jobId);
}