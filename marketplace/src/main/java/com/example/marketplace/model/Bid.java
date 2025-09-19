package com.example.marketplace.model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Bid {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "job_id")
@JsonBackReference
private Job job;


private String bidderName;
private BigDecimal amount;
private LocalDateTime createdAt;



// getters and setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getBidderName() { return bidderName; }
public void setBidderName(String bidderName) { this.bidderName = bidderName; }
public BigDecimal getAmount() { return amount; }
public void setAmount(BigDecimal amount) { this.amount = amount; }
public LocalDateTime getCreatedAt() { return createdAt; }
public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
public Job getJob() { return job; }
public void setJob(Job job) { this.job = job; }
}