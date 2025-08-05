package com.Jumpstart.Jumpstart.Promo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promos")
public class PromoController {
    @Autowired
    private PromoService promoService;

    @PostMapping
    public ResponseEntity<PromoDTO> createPromo(@RequestBody PromoDTO promoDTO) {
        return ResponseEntity.ok(promoService.createPromo(promoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromoDTO> getPromoById(@PathVariable Integer id) {
        return ResponseEntity.ok(promoService.getPromoById(id));
    }

    @GetMapping
    public ResponseEntity<List<PromoDTO>> getAllPromos() {
        return ResponseEntity.ok(promoService.getAllPromos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromoDTO> updatePromo(@PathVariable Integer id, @RequestBody PromoDTO promoDTO) {
        return ResponseEntity.ok(promoService.updatePromo(id, promoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromo(@PathVariable Integer id) {
        promoService.deletePromo(id);
        return ResponseEntity.ok().build();
    }
}