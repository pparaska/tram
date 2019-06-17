package io.eventuate.examples.tram.ordersandcustomers.orderhistoryviewservice.web.customers;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
