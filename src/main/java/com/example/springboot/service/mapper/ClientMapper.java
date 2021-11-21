package com.example.springboot.service.mapper;

import com.example.springboot.dto.ClientResponseDto;
import com.example.springboot.dto.CreateClientRequestDto;
import com.example.springboot.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client createDtoToModel(CreateClientRequestDto requestDto) {
        Client client = new Client();
        client.setFirstName(requestDto.getFirstName());
        client.setLastName(requestDto.getLastName());
        return client;
    }

    public ClientResponseDto ModelToDto(Client client) {
        ClientResponseDto responseDto = new ClientResponseDto();
        responseDto.setId(client.getId());
        responseDto.setFirstName(client.getFirstName());
        responseDto.setLastName(client.getLastName());
        return responseDto;
    }
}
