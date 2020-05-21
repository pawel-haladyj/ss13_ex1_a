package pl.haladyj.ss_basics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.haladyj.ss_basics.entity.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findProductById(Long id);
    Optional<Product> findProductByName(String name);
}
