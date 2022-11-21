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
import progweb.servershop.model.Product;
import progweb.servershop.service.ProductService;



@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;


   
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = this.productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") Long id){
        Optional<Product> newProduct = this.productService.findProductById(id);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        Product newProduct = this.productService.addNewProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }
}
