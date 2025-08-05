package com.Jumpstart.Jumpstart.Client;

import java.util.List;

public interface ClientService {
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO getClientById(Integer id);
    List<ClientDTO> getAllClients();
    ClientDTO updateClient(Integer id, ClientDTO clientDTO);
    void deleteClient(Integer id);
}