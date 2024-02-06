package competcommerce.service;

import competcommerce.persistence.entity.Product;
import competcommerce.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Optional<Product> getById(int productId) {
        if(!this.productRepository.existsById(productId)) {
            throw new RuntimeException("There's no records for the id provided");
        }
        return this.productRepository.findById(productId);
    }
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
    public void addOne(Product product) {
        this.productRepository.save(product);
    }
    public void addMany(List<Product> products) {
        this.productRepository.saveAll(products);
    }

    public void deleteById (int productId) {
        this.productRepository.deleteById(productId);
    }
}
