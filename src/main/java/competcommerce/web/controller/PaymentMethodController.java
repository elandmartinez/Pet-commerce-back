package competcommerce.web.controller;

import competcommerce.persistence.entity.PaymentMethod;
import competcommerce.service.ClientService;
import competcommerce.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/payment-methods")

public class PaymentMethodController {
    private final PaymentMethodService paymentMethodService;
    private final ClientService clientService;

    @Autowired
    public PaymentMethodController(PaymentMethodService paymentMethodService, ClientService clientService) {
        this.paymentMethodService = paymentMethodService;
        this.clientService = clientService;
    }

    @GetMapping("/get")
    public ResponseEntity getAll () {
        return ResponseEntity.ok(this.paymentMethodService.getAll());
    }

    @GetMapping("/get/{paymentMethodId}")
    public ResponseEntity getBydId (@PathVariable int paymentMethodId) {
        return ResponseEntity.ok(this.paymentMethodService.getById(paymentMethodId));
    }

    @PostMapping("/post/{amountToGenerate}")
    public ResponseEntity post (@PathVariable int amountToGenerate) {
        int totalAmountOfClients = this.clientService.getAll().size();
        ArrayList<PaymentMethod> paymentMethods = PaymentMethodDataGenerator.generatePayments(amountToGenerate, totalAmountOfClients);
        this.paymentMethodService.addMany(paymentMethods);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/post-payment-method")
    public ResponseEntity postOne (@RequestBody PaymentMethod newPaymentMethod) {
        this.paymentMethodService.addOne(newPaymentMethod);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-payment-method")
    public ResponseEntity update (@RequestBody PaymentMethod newPaymentMethod) {
        this.paymentMethodService.addOne(newPaymentMethod);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{paymentMethodId}")
    public ResponseEntity delete (@PathVariable int paymentMethodId) {
        this.paymentMethodService.deleteById(paymentMethodId);
        return ResponseEntity.ok().build();
    }
}
