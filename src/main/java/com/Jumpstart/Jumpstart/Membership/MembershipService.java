package com.Jumpstart.Jumpstart.Membership;


import java.util.List;

public interface MembershipService {
    MembershipDTO createMembership(MembershipDTO membershipDTO);
    MembershipDTO getMembershipById(Integer id);
    List<MembershipDTO> getAllMemberships();
    MembershipDTO updateMembership(Integer id, MembershipDTO membershipDTO);
    void deleteMembership(Integer id);
}