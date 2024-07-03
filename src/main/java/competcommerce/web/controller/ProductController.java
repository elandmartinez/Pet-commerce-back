package competcommerce.web.controller;

import competcommerce.persistence.entity.Product;
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

    @GetMapping("/get-paginated")
    public ResponseEntity getPaginated (@RequestParam(defaultValue = "0") int pagNum,
                                        @RequestParam(defaultValue = "10") int amountPerPag,
                                        @RequestParam(defaultValue = "name") String sortBy,
                                        @RequestParam(defaultValue = "ASC") String direction
    ) {
        return ResponseEntity.ok(this.productService.getAllPaginated(pagNum, amountPerPag, direction, sortBy));
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity getById(@PathVariable  int productId) {
        return ResponseEntity.ok(this.productService.getById(productId));
    }

    @PostMapping("/post")
    public ResponseEntity postProducts(@RequestBody ArrayList<Product> newProducts) {
        this.productService.addMany(newProducts);
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
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity deleteProduct(@PathVariable int productId) {
        this.productService.deleteById(productId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity deleteAll () {
        this.productService.deleteAll();
        return ResponseEntity.ok().build();
    }

}
