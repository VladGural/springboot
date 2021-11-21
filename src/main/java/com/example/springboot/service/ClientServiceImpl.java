package com.example.springboot.service;

import com.example.springboot.model.Client;
import com.example.springboot.repository.ClientRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client get(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> getAll() {
        return (List<Client>) clientRepository.findAll();
    }
}
