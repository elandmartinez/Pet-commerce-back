package competcommerce.service;

import competcommerce.persistence.entity.PaymentMethod;
import competcommerce.persistence.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }
    public List<PaymentMethod> getAll () {
        return this.paymentMethodRepository.findAll();
    }

    public Optional<PaymentMethod> getById(int paymentMethodId){
        if(!this.paymentMethodRepository.existsById(paymentMethodId)) {
            throw new RuntimeException("There's no records for the id provided");
        }
        return this.paymentMethodRepository.findById(paymentMethodId);
    }

    public void addMany(ArrayList<PaymentMethod> paymentMethods){
        this.paymentMethodRepository.saveAll(paymentMethods);
    }

    public void addOne(PaymentMethod newPaymentMethod) {
        this.paymentMethodRepository.save(newPaymentMethod);
    }

    public void deleteById (int paymentMethodId) { this.paymentMethodRepository.deleteById(paymentMethodId);}

}
