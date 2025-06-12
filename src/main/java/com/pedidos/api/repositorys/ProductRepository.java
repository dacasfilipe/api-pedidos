package com.pedidos.api.repositorys;
import com.pedidos.api.models.Product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    
    
}
