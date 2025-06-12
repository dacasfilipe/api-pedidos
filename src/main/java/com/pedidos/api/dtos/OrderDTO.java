package com.pedidos.api.dtos;

import java.util.List;

public class OrderDTO {
    private Long id;
    private String orderDate;
    private ClientDTO client;
    private List<ProductDTO> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

   

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public OrderDTO(Long id, String orderDate, ClientDTO client, List<ProductDTO> products) {
        this.id = id;
        this.orderDate = orderDate;
        this.client = client;
        this.products = products;
    }

    public OrderDTO() {
    }
    
}
