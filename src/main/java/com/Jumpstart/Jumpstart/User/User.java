package com.Jumpstart.Jumpstart.User;

import com.Jumpstart.Jumpstart.Membership.Membership;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "pictureURL")
    private String pictureURL;

    @Column(name = "waiverSignature")
    private String waiverSignature;

    @Column(name = "status")
    private String status;

    @Column(name = "referral_id")
    private String referralId;

    @Column(name = "club_id")
    private String clubId;

    @Column(name = "qrcodeToken")
    private String qrcodeToken;

    @ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getWaiverSignature() {
        return waiverSignature;
    }

    public void setWaiverSignature(String waiverSignature) {
        this.waiverSignature = waiverSignature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getQrcodeToken() {
        return qrcodeToken;
    }

    public void setQrcodeToken(String qrcodeToken) {
        this.qrcodeToken = qrcodeToken;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }
}