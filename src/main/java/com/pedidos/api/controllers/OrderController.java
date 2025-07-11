package com.pedidos.api.controllers;
import com.pedidos.api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.pedidos.api.dtos.OrderDTO;
import com.pedidos.api.models.Order;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    
    @GetMapping
    public List<Order> getAllOrders(@RequestParam(required = false) String status) {
        return orderService.getAllOrders(status);
    }
    
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        Order createdOrder = orderService.createOrder(orderDTO);
        OrderDTO createdOrderDTO = new OrderDTO(createdOrder); // Assuming a constructor or method exists to convert Order to OrderDTO
        return new ResponseEntity<>(createdOrderDTO, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }    
    
}
