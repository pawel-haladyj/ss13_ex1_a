package pl.haladyj.ss_basics.utils;

import org.springframework.stereotype.Component;
import pl.haladyj.ss_basics.entity.Product;
import pl.haladyj.ss_basics.service.dtos.ProductDto;

@Component
public class ProductConverter implements Converter<Product, ProductDto>{

    @Override
    public Product toProduct(ProductDto productDto) {
        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCurrency(productDto.getCurrency());

        return product;
    }

    @Override
    public ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setCurrency(product.getCurrency());

        return productDto;
    }
}
