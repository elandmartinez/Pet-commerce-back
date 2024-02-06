package competcommerce.web.controller;

import competcommerce.persistence.entity.Product;
import competcommerce.persistence.entityDataGenerators.ProductDataGenerator;
import competcommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(this.productService.getAll());
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity getById(@PathVariable  int productId) {
        return ResponseEntity.ok(this.productService.getById(productId));
    }

    @PostMapping("/post/{amountToGenerate}")
    public ResponseEntity postProducts(@PathVariable int amountToGenerate) {
        ArrayList<Product> productsToPush = ProductDataGenerator.generateProducts(amountToGenerate);
        this.productService.addMany(productsToPush);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/post-product")
    public ResponseEntity postProduct(@RequestBody Product product) {
        this.productService.addOne(product);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/update-product")
    public ResponseEntity updateProduct(@RequestBody Product product) {
        this.productService.addOne(product);
        return ResponseEntity.ok().build();

    }
    @DeleteMapping(value = "/delete/{productId}")
    public ResponseEntity deleteProduct(@PathVariable int productId) {
        this.productService.deleteById(productId);
        return ResponseEntity.badRequest().build();
    }

}
