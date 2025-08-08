package com.Jumpstart.Jumpstart.User;

import com.Jumpstart.Jumpstart.Membership.MembershipDTO;
import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String pictureURL;
    private String waiverSignature;
    private String status;
    private MembershipDTO membership; // Membership details
    private String referralId;
    private String clubId;
    private String qrcodeToken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public MembershipDTO getMembership() {
        return membership;
    }

    public void setMembership(MembershipDTO membership) {
        this.membership = membership;
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
}