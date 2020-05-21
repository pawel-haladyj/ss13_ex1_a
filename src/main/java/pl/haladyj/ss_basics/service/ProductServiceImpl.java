package pl.haladyj.ss_basics.service;

import pl.haladyj.ss_basics.entity.Product;
import pl.haladyj.ss_basics.service.dtos.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductServiceImpl {

    Optional<ProductDto> findProductByName(String name);
    Optional<ProductDto> findProductById(Long id);
    List<ProductDto> findAllProducts();
    Product createProduct(ProductDto productDto);
}
