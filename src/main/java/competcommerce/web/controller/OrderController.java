package competcommerce.web.controller;

import competcommerce.persistence.entity.Order;
import competcommerce.persistence.entityDataGenerators.OrderDataGenerator;
import competcommerce.service.ClientService;
import competcommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final ClientService clientService;

    public OrderController (OrderService orderService, ClientService clientService) {
        this.orderService = orderService;
        this.clientService = clientService;
    }

    @GetMapping("/get")
    public ResponseEntity get() {
        return ResponseEntity.ok(this.orderService.getAll());
    }

    @GetMapping("/get/{orderId}")
    public ResponseEntity getBydId(@PathVariable int orderId) {
        return ResponseEntity.ok(this.orderService.getBydId(orderId));
    }

    @PostMapping("/post/{amountToGenerate}")
    public ResponseEntity post (@PathVariable int amountToGenerate) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/post-order")
    public ResponseEntity postOne (@PathVariable Order newOrder) {
        this.orderService.addOne(newOrder);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-order")
    public ResponseEntity update (@PathVariable Order newOrder) {
        this.orderService.addOne(newOrder);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity deleteById (@PathVariable int orderId) {
        this.orderService.deleteById(orderId);
        return ResponseEntity.ok().build();
    }
}
