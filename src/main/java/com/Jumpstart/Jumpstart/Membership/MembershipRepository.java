package com.Jumpstart.Jumpstart.Membership;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {
    List<Membership> findByClubClubTag(String clubTag);
}