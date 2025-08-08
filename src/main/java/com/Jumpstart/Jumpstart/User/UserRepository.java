package com.Jumpstart.Jumpstart.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.membership WHERE u.clubId = :clubId")
    List<User> findByClubId(@Param("clubId") String clubId);
}