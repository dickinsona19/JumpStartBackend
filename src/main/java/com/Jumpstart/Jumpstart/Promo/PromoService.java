package com.Jumpstart.Jumpstart.Promo;


import java.util.List;

public interface PromoService {
    PromoDTO createPromo(PromoDTO promoDTO);
    PromoDTO getPromoById(Integer id);
    List<PromoDTO> getAllPromos();
    PromoDTO updatePromo(Integer id, PromoDTO promoDTO);
    void deletePromo(Integer id);
}