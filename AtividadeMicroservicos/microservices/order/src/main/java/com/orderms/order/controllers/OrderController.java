package com.orderms.order.controllers;

import com.orderms.order.dtos.ItemDto;
import com.orderms.order.dtos.OrderDto;
import com.orderms.order.dtos.StatusDto;
import com.orderms.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/id")
    public ResponseEntity<OrderDto> getOrderById(@RequestParam  Long id){
        return this.orderService.getOrderById(id);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return this.orderService.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
        return this.orderService.createOrder(orderDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id,
                                                @RequestBody OrderDto orderDto){
        return this.orderService.updateOrder(id, orderDto);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<OrderDto> updateStatusOrder(@PathVariable Long id,
                                                      @RequestBody StatusDto status){
        return this.orderService.updateStatusOrder(id, status);
    }

    @GetMapping("/status")
    public ResponseEntity<List<StatusDto>> getAllStatuses(){
        return this.orderService.getAllStatuses();
    }
    @GetMapping("/item")
    public ResponseEntity<List<ItemDto>> getAllItems(){
        return this.orderService.getAllItems();
    }

}
