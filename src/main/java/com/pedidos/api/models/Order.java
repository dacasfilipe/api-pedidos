import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false)
  private Client client;

  @ManyToMany
  @JoinTable(
    name = "order_products",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id")
  )
  private Set<Product> products;

  private LocalDateTime orderDate;

  // getters/setters...
}