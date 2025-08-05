package com.Jumpstart.Jumpstart.Membership;


import lombok.Data;

@Data
public class MembershipDTO {
    private Integer id;
    private String title;
    private String price;
    private String chargeInterval;
    private Integer promoId; // ID of the Promo

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getChargeInterval() {
        return chargeInterval;
    }

    public void setChargeInterval(String chargeInterval) {
        this.chargeInterval = chargeInterval;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }
}