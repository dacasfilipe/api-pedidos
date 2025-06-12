import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.pedidos.api.models.Product;
import com.pedidos.api.repositories.ProductRepository;


@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    
    public Product save(Product product) {
        return productRepository.save(product);
    }
    
    public Product update(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }
    
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
