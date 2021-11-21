package com.example.springboot.controller;

import com.example.springboot.dto.ClientResponseDto;
import com.example.springboot.dto.CreateClientRequestDto;
import com.example.springboot.service.ClientService;
import com.example.springboot.service.mapper.ClientMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientMapper clientMapper;
    private final ClientService clientService;

    public ClientController(ClientMapper clientMapper,
                            ClientService clientService) {
        this.clientMapper = clientMapper;
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ClientResponseDto create(@RequestBody CreateClientRequestDto requestDto) {
        return clientMapper.ModelToDto(clientService.add(clientMapper.createDtoToModel(requestDto)));
    }

    @GetMapping
    public List<ClientResponseDto> getAll() {
        return clientService.getAll().stream()
                .map(clientMapper::ModelToDto)
                .collect(Collectors.toList());
    }
}
