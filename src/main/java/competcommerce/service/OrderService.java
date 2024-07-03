package competcommerce.service;

import competcommerce.persistence.entity.Order;
import competcommerce.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService (OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll () {
        return this.orderRepository.findAll();
    }

    public Optional<Order> getBydId(int orderId) {
        if(this.orderRepository.existsById(orderId)) {
            throw new RuntimeException("There's no records for the id provided");
        }
        return this.orderRepository.findById(orderId);
    }

    public List<Order> getByClientId (String clientId) {
        this.orderRepository.getOrdersByClientId(clientId);
    }

    public void addMany (List<Order> orders) {this.orderRepository.saveAll(orders);}

    public void addOne (Order newOrder) { this.orderRepository.save(newOrder);}

    public void deleteById(int orderId){ this.orderRepository.deleteById(orderId);}
}
