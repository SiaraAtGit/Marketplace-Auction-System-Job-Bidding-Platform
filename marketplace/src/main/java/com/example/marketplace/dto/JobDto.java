package com.example.marketplace.dto;


import java.time.LocalDateTime;

import com.example.marketplace.model.Bid;


public class JobDto {
private String description;
private String requirements;
private String posterName;
private String posterContact;
private Bid winnerBid;
private LocalDateTime expiresAt;
// getters and setters
public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }
public String getRequirements() { return requirements; }
public void setRequirements(String requirements) { this.requirements = requirements; }
public String getPosterName() { return posterName; }
public void setPosterName(String posterName) { this.posterName = posterName; }
public String getPosterContact() { return posterContact; }
public void setPosterContact(String posterContact) { this.posterContact = posterContact; }
public LocalDateTime getExpiresAt() { return expiresAt; }
public void setExpiresAt(LocalDateTime expiresAt) { this.expiresAt = expiresAt; }
public Bid getWinnerBid() {
        return winnerBid;
    }
    public void setWinnerBid(Bid winnerBid) {
        this.winnerBid = winnerBid;
    }
}