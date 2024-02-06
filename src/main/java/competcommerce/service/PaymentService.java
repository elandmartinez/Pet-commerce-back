package competcommerce.service;

import competcommerce.persistence.entity.Payment;
import competcommerce.persistence.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService (PaymentRepository paymentRepository) { this.paymentRepository = paymentRepository;}


    public List<Payment> getAll () { return this.paymentRepository.findAll();}

    public Optional<Payment> getById (int paymentId) {
        if(!this.paymentRepository.existsById(paymentId)) {
            throw new RuntimeException("There's no records for the id provided");
        }
        return this.paymentRepository.findById(paymentId);
    }

    public void addMany (List<Payment> payments) { this.paymentRepository.saveAll(payments);}

    public void addOne (Payment payment) { this.paymentRepository.save(payment);}

    public void deleteById (int paymentId) { this.paymentRepository.deleteById(paymentId);}
}
