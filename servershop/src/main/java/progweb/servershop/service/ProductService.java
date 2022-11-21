package progweb.servershop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import progweb.servershop.model.Product;
import progweb.servershop.repository.ProductRepository;
/*
 * Uma classe de serviço é responsável por fornecer funcionalidades de transação na nossa aplicação.
 * Toda classe de serviço precisa ser anotada com @Service, e toda classe de serviço possui pelo
 * menos um repositório nela. Nesse caso a classe de serviço ProductService possui o 
 * productRepository.
 * É aqui que é criado métodos mais intuitivos para o controlador e usado as funcionalidades
 * do repositório.
 */
@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product addNewProduct(Product product){
        return this.productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id){
        return this.productRepository.findById(id);
    }
}
