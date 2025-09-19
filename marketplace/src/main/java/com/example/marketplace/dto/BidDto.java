package com.example.marketplace.dto;


import java.math.BigDecimal;


public class BidDto {
private String bidderName;
private BigDecimal amount;
// getters and setters
public String getBidderName() { return bidderName; }
public void setBidderName(String bidderName) { this.bidderName = bidderName; }
public BigDecimal getAmount() { return amount; }
public void setAmount(BigDecimal amount) { this.amount = amount; }
}