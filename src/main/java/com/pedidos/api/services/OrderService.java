package com.pedidos.api.services;

import com.pedidos.api.models.Order;
import com.pedidos.api.repositorys.OrderRepository;
import com.pedidos.api.exceptions.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
    
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    
    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = getOrderById(id);
        
        existingOrder.setClient(orderDetails.getClient());
        existingOrder.setProducts(orderDetails.getProducts());
        existingOrder.setOrderDate(orderDetails.getOrderDate());
        
        return orderRepository.save(existingOrder);
    }
    
    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }
}
