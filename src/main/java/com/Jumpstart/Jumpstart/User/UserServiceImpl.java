package com.Jumpstart.Jumpstart.User;

import com.Jumpstart.Jumpstart.Membership.Membership;
import com.Jumpstart.Jumpstart.Membership.MembershipDTO;
import com.Jumpstart.Jumpstart.Membership.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPictureURL(userDTO.getPictureURL());
        user.setWaiverSignature(userDTO.getWaiverSignature());
        user.setStatus(userDTO.getStatus());
        user.setReferralId(userDTO.getReferralId());
        user.setClubId(userDTO.getClubId());
        user.setQrcodeToken(userDTO.getQrcodeToken());

        if (userDTO.getMembership() != null) {
            Membership membership = membershipRepository.findById(userDTO.getMembership().getId())
                    .orElseThrow(() -> new RuntimeException("Membership not found"));
            user.setMembership(membership);
        }

        User savedUser = userRepository.save(user);
        return mapToDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<UserDTO> getUsersByClubId(String clubId) {
        return userRepository.findByClubId(clubId).stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(user.getId());
                    userDTO.setFirstName(user.getFirstName());
                    userDTO.setLastName(user.getLastName());
                    userDTO.setEmail(user.getEmail());
                    userDTO.setPassword(user.getPassword());
                    userDTO.setPictureURL(user.getPictureURL());
                    userDTO.setWaiverSignature(user.getWaiverSignature());
                    userDTO.setStatus(user.getStatus());
                    userDTO.setReferralId(user.getReferralId());
                    userDTO.setClubId(user.getClubId());
                    userDTO.setQrcodeToken(user.getQrcodeToken());

                    // Map Membership to MembershipDTO
                    if (user.getMembership() != null) {
                        MembershipDTO membershipDTO = new MembershipDTO();
                        membershipDTO.setId(user.getMembership().getId());
                        membershipDTO.setTitle(user.getMembership().getTitle());
                        membershipDTO.setPrice(user.getMembership().getPrice());
                        membershipDTO.setChargeInterval(user.getMembership().getChargeInterval());
                        membershipDTO.setPromo(user.getMembership().getPromo());
                        userDTO.setMembership(membershipDTO);
                    }

                    return userDTO;
                }).collect(Collectors.toList());
    }
    private UserDTO mapEntityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setPictureURL(user.getPictureURL());
        userDTO.setWaiverSignature(user.getWaiverSignature());
        userDTO.setStatus(user.getStatus());
        userDTO.setReferralId(user.getReferralId());
        userDTO.setClubId(user.getClubId());
        userDTO.setQrcodeToken(user.getQrcodeToken());
        if (user.getMembership() != null) {
            userDTO.setMembership(MembershipDTO.toMembershipDTO(user.getMembership()));
        }
        return userDTO;
    }
    @Override
    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPictureURL(userDTO.getPictureURL());
        user.setWaiverSignature(userDTO.getWaiverSignature());
        user.setStatus(userDTO.getStatus());
        user.setReferralId(userDTO.getReferralId());
        user.setClubId(userDTO.getClubId());
        user.setQrcodeToken(userDTO.getQrcodeToken());

        if (userDTO.getMembership() != null) {
            Membership membership = membershipRepository.findById(userDTO.getMembership().getId())
                    .orElseThrow(() -> new RuntimeException("Membership not found"));
            user.setMembership(membership);
        } else {
            user.setMembership(null);
        }

        User updatedUser = userRepository.save(user);
        return mapToDTO(updatedUser);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setPictureURL(user.getPictureURL());
        dto.setWaiverSignature(user.getWaiverSignature());
        dto.setStatus(user.getStatus());
        dto.setMembership(user.getMembership() != null ? MembershipDTO.toMembershipDTO(user.getMembership()) : null);
        dto.setReferralId(user.getReferralId());
        dto.setClubId(user.getClubId());
        dto.setQrcodeToken(user.getQrcodeToken());
        return dto;
    }
}