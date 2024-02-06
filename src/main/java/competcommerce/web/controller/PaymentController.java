package competcommerce.web.controller;

import competcommerce.persistence.entity.Payment;
import competcommerce.persistence.entityDataGenerators.PaymentDataGenerator;
import competcommerce.service.ClientService;
import competcommerce.service.OrderService;
import competcommerce.service.PaymentMethodService;
import competcommerce.service.PaymentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/payments")
public class PaymentController {
    private final PaymentService paymentService;
    private final ClientService clientService;
    private final PaymentMethodService paymentMethodService;
    private final OrderService orderService;

    @Autowired
    public PaymentController (PaymentService paymentService, ClientService clientService, PaymentMethodService paymentMethodService, OrderService orderService) {
        this.clientService = clientService;
        this.paymentMethodService = paymentMethodService;
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    @GetMapping("/get")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.paymentService.getAll());
    }

    @GetMapping("/get/{paymentId}")
    public ResponseEntity getById(@PathVariable int paymentId) {
        return ResponseEntity.ok(this.paymentService.getById(paymentId));
    }

    @PostMapping("/post/{amountToGenerate}")
    public ResponseEntity post(@PathVariable int amountToGenerate) {
        int totalAmountOfClients = this.clientService.getAll().size();
        int totalAmountOfPaymentMethods = this.paymentMethodService.getAll().size();
        int totalAmountOfOrders = this.orderService.getAll().size();

        ArrayList<Payment> newPayments = PaymentDataGenerator.generatePayments(amountToGenerate, totalAmountOfPaymentMethods, totalAmountOfClients, totalAmountOfOrders);
        this.paymentService.addMany(newPayments);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/post-payment")
    public ResponseEntity postOne(@RequestBody Payment newPayment) {
        this.paymentService.addOne(newPayment);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-client")
    public ResponseEntity update(@RequestBody Payment newPayment) {
        this.paymentService.addOne(newPayment);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{paymentId}")
    public ResponseEntity deleteBydId(@PathVariable int paymentId) {
        this.paymentService.deleteById(paymentId);
        return ResponseEntity.ok().build();
    }
}
