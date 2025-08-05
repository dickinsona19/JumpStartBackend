package com.Jumpstart.Jumpstart.Club;

import java.util.List;

public interface ClubService {
    ClubDTO createClub(ClubDTO clubDTO);
    ClubDTO getClubById(Integer id);
    List<ClubDTO> getAllClubs();
    ClubDTO updateClub(Integer id, ClubDTO clubDTO);
    void deleteClub(Integer id);
}