package com.pedidos.api.models;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @OneToMany(mappedBy = "client")
  private Set<Order> orders;

  // getters/setters...
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public Set<Order> getOrders() {
    return orders;
}

public void setOrders(Set<Order> orders) {
    this.orders = orders;
}
}