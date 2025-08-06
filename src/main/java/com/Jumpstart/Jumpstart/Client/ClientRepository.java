package com.Jumpstart.Jumpstart.Client;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByEmail(String email);
    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.clubs WHERE c.id = :id")
    Client findByIdWithClubs(@Param("id") Integer id);

}