package progweb.servershop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import progweb.servershop.model.Order;
import progweb.servershop.repository.OrderRepository;
/*
 * Uma classe de serviço é responsável por fornecer funcionalidades de transação na nossa aplicação.
 * Toda classe de serviço precisa ser anotada com @Service, e toda classe de serviço possui pelo
 * menos um repositório nela. Nesse caso a classe de serviço OrderService possui o 
 * orderRepository.
 * É aqui que é criado métodos mais intuitivos para o controlador e usado as funcionalidades
 * do repositório.
 */

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Order order){
        return this.orderRepository.save(order);
    }

    public List<Order> getAllOrders(){
        return this.orderRepository.findAll();
    }

    public Optional<Order> findOrderById(Long id){
        return this.orderRepository.findById(id);
    }
}
