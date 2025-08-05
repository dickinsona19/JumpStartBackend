package com.Jumpstart.Jumpstart.Promo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromoServiceImpl implements PromoService {
    @Autowired
    private PromoRepository promoRepository;

    @Override
    public PromoDTO createPromo(PromoDTO promoDTO) {
        Promo promo = new Promo();
        promo.setTitle(promoDTO.getTitle());
        promo.setType(promoDTO.getType());
        promo.setDiscount(promoDTO.getDiscount());
        promo.setDuration(promoDTO.getDuration());
        promo.setCode(promoDTO.getCode());
        Promo savedPromo = promoRepository.save(promo);
        return mapToDTO(savedPromo);
    }

    @Override
    public PromoDTO getPromoById(Integer id) {
        Promo promo = promoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promo not found"));
        return mapToDTO(promo);
    }

    @Override
    public List<PromoDTO> getAllPromos() {
        return promoRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PromoDTO updatePromo(Integer id, PromoDTO promoDTO) {
        Promo promo = promoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promo not found"));
        promo.setTitle(promoDTO.getTitle());
        promo.setType(promoDTO.getType());
        promo.setDiscount(promoDTO.getDiscount());
        promo.setDuration(promoDTO.getDuration());
        promo.setCode(promoDTO.getCode());
        Promo updatedPromo = promoRepository.save(promo);
        return mapToDTO(updatedPromo);
    }

    @Override
    public void deletePromo(Integer id) {
        promoRepository.deleteById(id);
    }

    private PromoDTO mapToDTO(Promo promo) {
        PromoDTO dto = new PromoDTO();
        dto.setId(promo.getId());
        dto.setTitle(promo.getTitle());
        dto.setType(promo.getType());
        dto.setDiscount(promo.getDiscount());
        dto.setDuration(promo.getDuration());
        dto.setCode(promo.getCode());
        return dto;
    }
}