package com.example.marketplace.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Job {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(length = 16384)
private String description;


@Column(length = 16384)
private String requirements;

@OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JsonManagedReference
private List<Bid> bids = new ArrayList<>();


private String posterName;
private String posterContact;
private LocalDateTime createdAt;
private LocalDateTime expiresAt;

@OneToOne
@JoinColumn(name="winner_bid_id")
private Bid winnerBid;




// getters and setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }
public String getRequirements() { return requirements; }
public void setRequirements(String requirements) { this.requirements = requirements; }
public String getPosterName() { return posterName; }
public void setPosterName(String posterName) { this.posterName = posterName; }
public String getPosterContact() { return posterContact; }
public void setPosterContact(String posterContact) { this.posterContact = posterContact; }
public LocalDateTime getCreatedAt() { return createdAt; }
public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
public LocalDateTime getExpiresAt() { return expiresAt; }
public void setExpiresAt(LocalDateTime expiresAt) { this.expiresAt = expiresAt; }
public List<Bid> getBids() { return bids; }
public void setBids(List<Bid> bids) { this.bids = bids; }
public Bid getWinnerBid() {
        return winnerBid;
    }
    public void setWinnerBid(Bid winnerBid) {
        this.winnerBid = winnerBid;
    }
}