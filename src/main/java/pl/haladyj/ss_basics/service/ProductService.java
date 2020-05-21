package pl.haladyj.ss_basics.service;

import org.springframework.stereotype.Service;
import pl.haladyj.ss_basics.entity.Product;
import pl.haladyj.ss_basics.exceptions.ProductNameDuplicateException;
import pl.haladyj.ss_basics.repository.ProductRepository;
import pl.haladyj.ss_basics.service.dtos.ProductDto;
import pl.haladyj.ss_basics.utils.ProductConverter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServiceImpl{

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public ProductService(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }


    @Override
    public Optional<ProductDto> findProductByName(String name) {
        return productRepository
                .findProductByName(name)
                .map(product -> productConverter.toProductDto(product));
    }

    @Override
    public Optional<ProductDto> findProductById(Long id) {
        return productRepository
                .findProductById(id)
                .map(product -> productConverter.toProductDto(product));
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(product -> productConverter.toProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public Product createProduct(ProductDto productDto) {

        Optional<Product> optProduct = productRepository.findProductByName(productDto.getName());

        if(optProduct.isPresent()){
            throw new ProductNameDuplicateException("product name allready exists in datascope");
        }

        Product product = productConverter.toProduct(productDto);
        return productRepository.save(product);
    }
}
