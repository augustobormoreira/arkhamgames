package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.model.Produto;
import shop.model.repository.ProdutoRepository;
import shop.model.service.ProdutoService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins= "*", allowedHeaders = "*")

public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private ProdutoService service;
    @GetMapping
    public ResponseEntity<List<Produto>> findAllByProdutos() {
        return  ResponseEntity.ok(repository.findAll());
    }
    


