package pl.haladyj.ss_basics.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.haladyj.ss_basics.entity.Product;
import pl.haladyj.ss_basics.service.ProductService;
import pl.haladyj.ss_basics.service.dtos.ProductDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/id/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable("id") Long id){
        Optional<ProductDto> productDtoOpt = productService.findProductById(id);

        if(productDtoOpt.isPresent()){
            return ResponseEntity.ok(productDtoOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/product/name/{name}")
    public ResponseEntity<ProductDto> findProductByName(@PathVariable("name") String name){
        Optional<ProductDto> productDtoOpt = productService.findProductByName(name);

        if(productDtoOpt.isPresent()){
            return ResponseEntity.ok(productDtoOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> productDtos = productService.findAllProducts();

        return ResponseEntity.ok(productDtos);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        Product product = productService.createProduct(productDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
