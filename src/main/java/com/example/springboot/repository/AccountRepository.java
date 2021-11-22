package com.example.springboot.repository;

import com.example.springboot.dto.OwnerDto;
import com.example.springboot.model.Account;
import com.example.springboot.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query(value = "SELECT c.id, c.first_name, c.last_name "
            + "FROM clients c "
            + "INNER JOIN clients_accounts ca ON c.id = ca.client_id "
            + "WHERE ca.accounts_id = ?1", nativeQuery = true)
    OwnerDto getOwner(Long id);
}

