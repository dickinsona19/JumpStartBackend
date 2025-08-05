package com.Jumpstart.Jumpstart.Club;


import com.Jumpstart.Jumpstart.Client.Client;
import com.Jumpstart.Jumpstart.Client.ClientRepository;
import com.Jumpstart.Jumpstart.Membership.Membership;
import com.Jumpstart.Jumpstart.Membership.MembershipRepository;
import com.Jumpstart.Jumpstart.Staff.Staff;
import com.Jumpstart.Jumpstart.Staff.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public ClubDTO createClub(ClubDTO clubDTO) {
        Club club = new Club();
        club.setTitle(clubDTO.getTitle());
        club.setLogoUrl(clubDTO.getLogoUrl());
        club.setStatus(clubDTO.getStatus());
        club.setCreatedAt(clubDTO.getCreatedAt());
        club.setUserId(clubDTO.getUserId());
        club.setClubTag(clubDTO.getClubTag());

        // Set relationships
        if (clubDTO.getClientId() != null) {
            Client client = clientRepository.findById(clubDTO.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client not found"));
            club.setClient(client);
        }
        if (clubDTO.getStaffId() != null) {
            Staff staff = staffRepository.findById(clubDTO.getStaffId())
                    .orElseThrow(() -> new RuntimeException("Staff not found"));
            club.setStaff(staff);
        }
        if (clubDTO.getMembershipId() != null) {
            Membership membership = membershipRepository.findById(clubDTO.getMembershipId())
                    .orElseThrow(() -> new RuntimeException("Membership not found"));
            club.setMembership(membership);
        }

        Club savedClub = clubRepository.save(club);
        return mapToDTO(savedClub);
    }

    @Override
    public ClubDTO getClubById(Integer id) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Club not found"));
        return mapToDTO(club);
    }

    @Override
    public List<ClubDTO> getAllClubs() {
        return clubRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClubDTO updateClub(Integer id, ClubDTO clubDTO) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Club not found"));
        club.setTitle(clubDTO.getTitle());
        club.setLogoUrl(clubDTO.getLogoUrl());
        club.setStatus(clubDTO.getStatus());
        club.setCreatedAt(clubDTO.getCreatedAt());
        club.setUserId(clubDTO.getUserId());
        club.setClubTag(clubDTO.getClubTag());

        // Update relationships
        if (clubDTO.getClientId() != null) {
            Client client = clientRepository.findById(clubDTO.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client not found"));
            club.setClient(client);
        } else {
            club.setClient(null);
        }
        if (clubDTO.getStaffId() != null) {
            Staff staff = staffRepository.findById(clubDTO.getStaffId())
                    .orElseThrow(() -> new RuntimeException("Staff not found"));
            club.setStaff(staff);
        } else {
            club.setStaff(null);
        }
        if (clubDTO.getMembershipId() != null) {
            Membership membership = membershipRepository.findById(clubDTO.getMembershipId())
                    .orElseThrow(() -> new RuntimeException("Membership not found"));
            club.setMembership(membership);
        } else {
            club.setMembership(null);
        }

        Club updatedClub = clubRepository.save(club);
        return mapToDTO(updatedClub);
    }

    @Override
    public void deleteClub(Integer id) {
        clubRepository.deleteById(id);
    }

    private ClubDTO mapToDTO(Club club) {
        ClubDTO dto = new ClubDTO();
        dto.setId(club.getId());
        dto.setTitle(club.getTitle());
        dto.setLogoUrl(club.getLogoUrl());
        dto.setStatus(club.getStatus());
        dto.setCreatedAt(club.getCreatedAt());
        dto.setUserId(club.getUserId());
        dto.setClubTag(club.getClubTag());
        dto.setClientId(club.getClient() != null ? club.getClient().getId() : null);
        dto.setStaffId(club.getStaff() != null ? club.getStaff().getId() : null);
        dto.setMembershipId(club.getMembership() != null ? club.getMembership().getId() : null);
        return dto;
    }
}