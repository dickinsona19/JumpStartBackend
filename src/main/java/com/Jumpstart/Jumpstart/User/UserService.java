package com.Jumpstart.Jumpstart.User;


import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Integer id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Integer id, UserDTO userDTO);
    void deleteUser(Integer id);
    List<UserDTO> getUsersByClubId(String clubId);
}