package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    Map<UUID,Customer> customerMap;

    public CustomerServiceImpl(){
        this.customerMap = new HashMap<>();

        var customer1 = Customer.builder()
                .customerName("customer1")
                .createdDate(LocalDateTime.now())
                .version(2)
                .id(UUID.randomUUID())
                .lastModifiedDate(LocalDateTime.now())
                .build();
        var customer2 = Customer.builder()
                .customerName("customer2")
                .createdDate(LocalDateTime.now())
                .version(2)
                .id(UUID.randomUUID())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        var customer3 = Customer.builder()
                .customerName("customer3")
                .createdDate(LocalDateTime.now())
                .version(2)
                .id(UUID.randomUUID())
                .lastModifiedDate(LocalDateTime.now())
                .build();
        customerMap.put(customer1.getId(),customer1);
        customerMap.put(customer2.getId(),customer2);
        customerMap.put(customer3.getId(),customer3);
    }

    @Override
    public void updateCustomerById(UUID customerId, Customer customer) {
        Customer existing = customerMap.get(customerId);
        existing.setCustomerName(customer.getCustomerName());
        existing.setLastModifiedDate(LocalDateTime.now());
    }

    @Override
    public List<Customer> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return customerMap.get(id);
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .customerName(customer.getCustomerName())
                .build();
        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }


}
