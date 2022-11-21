package progweb.servershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import progweb.servershop.model.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
