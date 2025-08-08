package com.Jumpstart.Jumpstart.Membership;
import com.Jumpstart.Jumpstart.Club.Club;
import com.Jumpstart.Jumpstart.Promo.Promo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "membership")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String price;

    @Column(name = "charge_interval")
    private String chargeInterval;

    @ManyToOne
    @JoinColumn(name = "promo_id")
    private Promo promo;

    @ManyToOne
    @JoinColumn(name = "club_tag", referencedColumnName = "club_tag")
        private Club club;


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


    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club clubTag) {
        this.club = clubTag;
    }
}