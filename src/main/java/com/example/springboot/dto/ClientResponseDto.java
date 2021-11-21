package com.example.springboot.dto;

import java.util.List;
import lombok.Data;

@Data
public class ClientResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<AccountResponseDto> accounts;
}
