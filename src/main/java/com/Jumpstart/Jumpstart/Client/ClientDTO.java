package com.Jumpstart.Jumpstart.Client;

import com.Jumpstart.Jumpstart.Club.ClubDTO;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ClientDTO {
    private Integer id;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private String status;
    private String stripeAccountId;
    private List<ClubDTO> clubs = new ArrayList<>();

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStripeAccountId() {
        return stripeAccountId;
    }

    public void setStripeAccountId(String stripeAccountId) {
        this.stripeAccountId = stripeAccountId;
    }

    public List<ClubDTO> getClubs() {
        return clubs;
    }

    public void setClubs(List<ClubDTO> clubs) {
        this.clubs = clubs;
    }
}