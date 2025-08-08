package com.Jumpstart.Jumpstart.Membership;



import com.Jumpstart.Jumpstart.Club.Club;
import com.Jumpstart.Jumpstart.Club.ClubRepository;
import com.Jumpstart.Jumpstart.Promo.Promo;
import com.Jumpstart.Jumpstart.Promo.PromoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MembershipServiceImpl implements MembershipService {
    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private PromoRepository promoRepository;


    @Autowired
    private ClubRepository clubRepository;

    @Override
    public MembershipDTO createMembership(MembershipDTO membershipDTO) {
        Membership membership = new Membership();
        membership.setTitle(membershipDTO.getTitle());
        membership.setPrice(membershipDTO.getPrice());
        membership.setChargeInterval(membershipDTO.getChargeInterval());

        if (membershipDTO.getPromo() != null) {
            Promo promo = promoRepository.findById(membershipDTO.getPromo().getId())
                    .orElseThrow(() -> new RuntimeException("Promo not found"));
            membership.setPromo(promo);
        }
        if (membershipDTO.getClubTag() != null) {
            Club club = clubRepository.findByClubTag(membershipDTO.getClubTag())
                    .orElseThrow(() -> new RuntimeException("Club not found for clubTag: " + membershipDTO.getClubTag()));
            membership.setClub(club);
        } else {
            throw new IllegalArgumentException("clubTag must not be null");
        }


        Membership savedMembership = membershipRepository.save(membership);
        return mapToDTO(savedMembership);
    }

    @Override
    public MembershipDTO getMembershipById(Integer id) {
        Membership membership = membershipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("membership not found"));
        return mapToDTO(membership);
    }

    @Override
    public List<MembershipDTO> getAllMemberships() {
        return membershipRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MembershipDTO updateMembership(Integer id, MembershipDTO membershipDTO) {
        Membership membership = membershipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("membership not found"));
        membership.setTitle(membershipDTO.getTitle());
        membership.setPrice(membershipDTO.getPrice());
        membership.setChargeInterval(membershipDTO.getChargeInterval());

        if (membershipDTO.getPromo() != null) {
            Promo promo = promoRepository.findById(membershipDTO.getPromo().getId())
                    .orElseThrow(() -> new RuntimeException("Promo not found"));
            membership.setPromo(promo);
        } else {
            membership.setPromo(null);
        }

        Membership updatedMembership = membershipRepository.save(membership);
        return mapToDTO(updatedMembership);
    }

    @Override
    public void deleteMembership(Integer id) {
        membershipRepository.deleteById(id);
    }

    private MembershipDTO mapToDTO(Membership membership) {
        MembershipDTO dto = new MembershipDTO();
        dto.setId(membership.getId());
        dto.setTitle(membership.getTitle());
        dto.setPrice(membership.getPrice());
        dto.setChargeInterval(membership.getChargeInterval());
        dto.setPromo(membership.getPromo() != null ? membership.getPromo() : null);
        dto.setClubTag(membership.getClub() != null ? membership.getClub().getClubTag() : null);
        return dto;
    }

}