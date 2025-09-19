# Marketplace-Auction-System-Job-Bidding-Platform
A real-time job auction platform where users can post jobs, place bids, and automatically determine the lowest-bid winner when the auction ends. Built with Spring Boot, Hibernate, and JavaScript.
---

## Table of Contents
- [Overview](#overview)  
- [Features](#features)  
- [Technologies](#technologies)  
- [Future Enhancements](#future-enhancements)  

---

## Overview
This project is a web-based marketplace that allows job posters to publish tasks and enables users to place bids on those tasks. The system automatically determines the winning bidder based on the lowest bid once the auction expires. It is built with Spring Boot for the backend and vanilla JavaScript for the frontend.

---

## Features
- Post new jobs with a description, requirements, and expiration date.  
- Place bids on active jobs.  
- Automatically assign the lowest bidder as the winner when the auction expires.  
- Display recent jobs and active jobs on the homepage.  
- Show bid statistics: lowest bid, number of bids, and winner information.  
- Auto-refresh frontend to show the latest bids and winner information.  

---

## Technologies
- **Backend:** Java, Spring Boot, Hibernate, JPA  
- **Frontend:** HTML, CSS, JavaScript  
- **Database:** H2 / MySQL (configurable)  
- **Scheduling:** Spring @Scheduled for automatic auction closure  
- **Build Tool:** Maven  

---

         
## Future Enhancements
- Add user authentication & authorization.
- Email notifications for job updates and winning bids.
- Pagination for job lists.
- Analytics dashboard for job posters.
- Enhanced UI using React or Angular.
