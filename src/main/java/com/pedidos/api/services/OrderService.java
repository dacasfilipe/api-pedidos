package com.pedidos.api.services;

import com.pedidos.api.models.Client;
import com.pedidos.api.models.Order;
import com.pedidos.api.models.Product;
import com.pedidos.api.repositorys.OrderRepository;
import com.pedidos.api.dtos.OrderDTO;
import com.pedidos.api.exceptions.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getAllOrders(String status) {
        // Para implementação futura de filtro por status
        return orderRepository.findAll();
    }
    
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Pedido não encontrado com ID: " + id));
    }
    
    public Order createOrder(OrderDTO orderDTO) {
        if (orderDTO == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (orderDTO.getClient() == null) {
            throw new IllegalArgumentException("Client cannot be null when creating an order.");
        }
        Order order = new Order();
        // Convert ClientDTO to Client
        Client client = new Client();
        client.setId(orderDTO.getClient().getId());
        client.setName(orderDTO.getClient().getName());
        client.setEmail(orderDTO.getClient().getEmail());
        order.setClient(client);
        order.setProducts(orderDTO.getProducts().stream()
                .map(productDTO -> new Product(productDTO.getId(), productDTO.getName(), productDTO.getPrice()))
                .collect(Collectors.toSet()));
        order.setOrderDate(LocalDateTime.parse(orderDTO.getOrderDate()));
        if (order.getClient() == null || order.getProducts() == null || order.getOrderDate() == null) {
            throw new IllegalArgumentException("Order must have a client, products, and an order date");
        }
        if (order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one product");
        }
        if (order.getClient().getId() == null) {
            throw new IllegalArgumentException("Order must have a valid client ID");
        }
        return orderRepository.save(order);
    }
    
    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = getOrderById(id);
        
        existingOrder.setProducts(orderDetails.getProducts().stream()
                .map(product -> new Product(product.getId(), product.getName(), product.getPrice()))
                .collect(Collectors.toSet()));
        existingOrder.setOrderDate(orderDetails.getOrderDate());
        
        return orderRepository.save(existingOrder);
    }
    
    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }
}
