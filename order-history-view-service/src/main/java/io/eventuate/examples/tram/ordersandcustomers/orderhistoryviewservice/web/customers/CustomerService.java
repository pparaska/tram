package io.eventuate.examples.tram.ordersandcustomers.orderhistoryviewservice.web.customers;

import org.springframework.beans.factory.annotation.Autowired;
import io.eventuate.examples.tram.ordersandcustomers.commondomain.Money;
import io.eventuate.tram.events.ResultWithEvents;
import io.eventuate.tram.events.publisher.DomainEventPublisher;

public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private DomainEventPublisher domainEventPublisher;

  public Customer createCustomer(String name, Money creditLimit) {
    ResultWithEvents<Customer> customerWithEvents = Customer.create(name, creditLimit);
    Customer customer = customerRepository.save(customerWithEvents.result);
    domainEventPublisher.publish(Customer.class, customer.getId(), customerWithEvents.events);
    return customer;
  }
}
