package com.orderms.order.services;

import com.orderms.order.dtos.ItemDto;
import com.orderms.order.dtos.OrderDto;
import com.orderms.order.dtos.StatusDto;
import com.orderms.order.entities.Order;
import com.orderms.order.entities.Status;
import com.orderms.order.repositories.ItemRepository;
import com.orderms.order.repositories.OrderRepository;
import com.orderms.order.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private StatusRepository statusRepository;

    public ResponseEntity<OrderDto> getOrderById(Long id){
        return this.orderRepository.findById(id)
                                    .map((order)-> ResponseEntity.ok(new OrderDto(order)))
                                    .orElseGet(()-> ResponseEntity.notFound().build());
    }
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        List<OrderDto> orderDtoList = this.orderRepository.findAll().stream()
                                                                .map(OrderDto::new)
                                                                .toList();
        return ResponseEntity.ok(orderDtoList);
    }
    public ResponseEntity<OrderDto> createOrder(OrderDto orderDto){
        Order newOrder = this.orderRepository.save(new Order(orderDto));
        return ResponseEntity.ok(new OrderDto(newOrder));
    }
    public ResponseEntity<OrderDto> updateOrder(Long id, OrderDto orderDto){
        if(!this.orderRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        Order order = new Order(orderDto);
        order.setId(id);

        order = this.orderRepository.save(order);

        return ResponseEntity.ok(new OrderDto(order));
    }

    public ResponseEntity<OrderDto> updateStatusOrder(Long id, StatusDto status){
        Optional<Order> order = this.orderRepository.findById(id);

        if(!order.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Order oldOrder = order.get();

        oldOrder.setStatus(new Status(status));

        oldOrder = this.orderRepository.save(oldOrder);

        return ResponseEntity.ok(new OrderDto(oldOrder));
    }
    public ResponseEntity<List<StatusDto>> getAllStatuses(){
        List<StatusDto> statusDtoList = this.statusRepository.findAll().stream()
                .map(StatusDto::new)
                .toList();
        return ResponseEntity.ok(statusDtoList);
    }

    public ResponseEntity<List<ItemDto>> getAllItems(){
        List<ItemDto> itemDtoList = this.itemRepository.findAll().stream()
                .map(ItemDto::new)
                .toList();
        return ResponseEntity.ok(itemDtoList);
    }
}
