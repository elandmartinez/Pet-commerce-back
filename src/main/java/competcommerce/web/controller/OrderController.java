package competcommerce.web.controller;

import competcommerce.persistence.entity.Order;
import competcommerce.persistence.entityDataGenerators.OrderDataGenerator;
import competcommerce.service.ClientService;
import competcommerce.service.OrderService;
import competcommerce.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final ClientService clientService;
    private final PaymentService paymentService;

    public OrderController (OrderService orderService, ClientService clientService, PaymentService paymentService) {
        this.orderService = orderService;
        this.clientService = clientService;
        this.paymentService = paymentService;
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
        int totalAmountOfClients = this.clientService.getAll().size();
        int totalAmountOfPayments = this.paymentService.getAll().size();
        ArrayList<Order> newOrders = OrderDataGenerator.generateOrders(amountToGenerate, totalAmountOfClients, totalAmountOfPayments);
        this.orderService.addMany(newOrders);

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
