package com.example.springboot.service;

import com.example.springboot.model.Client;
import java.util.List;

public interface ClientService {
    Client add(Client client);

    Client update(Client client);

    Client get(Long id);

    List<Client> getAll();
}
