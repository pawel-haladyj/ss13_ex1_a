package pl.haladyj.ss_basics.service.dtos;

import pl.haladyj.ss_basics.entity.Currency;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDto {

    private String name;
    private BigDecimal price;
    private Currency currency;

    public ProductDto() {
    }

    public ProductDto(String name, BigDecimal price, Currency currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                currency == that.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, currency);
    }
}
