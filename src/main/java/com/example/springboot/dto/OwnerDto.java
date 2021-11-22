package com.example.springboot.dto;

import com.example.springboot.model.Account;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.OneToMany;

public class OwnerDto {
    private Long id;
    private String firstName;
    private String lastName;
}
