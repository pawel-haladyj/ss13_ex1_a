package pl.haladyj.ss_basics.utils;

public interface Converter<Product, ProductDto> {

    Product toProduct(ProductDto productDto);
    ProductDto toProductDto(Product product);
}
