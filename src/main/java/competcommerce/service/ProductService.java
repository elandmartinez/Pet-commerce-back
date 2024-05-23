package competcommerce.service;

import competcommerce.persistence.entity.Product;
import competcommerce.persistence.repository.ProductRepository;
import competcommerce.persistence.repository.pagination.ProductPagSortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductPagSortRepository productPagRepository;

    @Autowired
    public ProductService (ProductRepository productRepository, ProductPagSortRepository productPagRepository) {
        this.productPagRepository = productPagRepository;
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

    public Page getAllPaginated(int pagNum, int amountPerPag, String direction, String sortBy) {
        Sort sort  = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageRequest = PageRequest.of(pagNum, amountPerPag, sort);
        return this.productPagRepository.findAll(pageRequest);
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
