package com.pedidos.api.models;

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
  

  public Order(Long id, Client client, Set<Product> products, LocalDateTime orderDate) {
    this.id = id;
    this.client = client;
    this.products = products;
    this.orderDate = orderDate;
  }
  public Order() {
    // Default constructor
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Set<Product> getProducts() {
    return products;
  }

  public void setProducts(Set<Product> products) {
    this.products = products;
  }

  public LocalDateTime getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(LocalDateTime orderDate) {
    this.orderDate = orderDate;
  }

  // getters/setters...
  
}