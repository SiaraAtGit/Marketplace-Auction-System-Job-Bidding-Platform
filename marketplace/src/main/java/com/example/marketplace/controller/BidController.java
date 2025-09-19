package com.example.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.marketplace.model.Bid;
import com.example.marketplace.service.MarketplaceService;


@RestController
@RequestMapping("/api/jobs/{jobId}/bids")
public class BidController {
    @Autowired MarketplaceService service;
    @PostMapping Bid bid(@PathVariable Long jobId, @RequestBody Bid bid) {
        return service.placeBid(jobId, bid);
    }
}
