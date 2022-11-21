package progweb.servershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import progweb.servershop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
