package progweb.servershop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import progweb.servershop.model.Order;
import progweb.servershop.service.OrderService;



@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Order newOrder = this.orderService.createOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = this.orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable("id") Long id){
        Optional<Order> newOrder = this.orderService.findOrderById(id);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }
}
