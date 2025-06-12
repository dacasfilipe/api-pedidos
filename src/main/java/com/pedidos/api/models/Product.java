package com.pedidos.api.models;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Double price;

  public Product(Long id2, String name2, Double price2) {
    //TODO Auto-generated constructor stub
    this.id = id2;
    this.name = name2;
    this.price = price2;
  }
  public Product() {
    // Default constructor
  }

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

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
