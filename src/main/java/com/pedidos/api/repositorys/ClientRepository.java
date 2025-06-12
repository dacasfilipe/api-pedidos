package com.pedidos.api.repositorys;
import com.pedidos.api.models.Client;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
