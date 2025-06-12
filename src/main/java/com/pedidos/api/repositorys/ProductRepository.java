import com.pedidos.api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

package com.pedidos.api.repositorys;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
