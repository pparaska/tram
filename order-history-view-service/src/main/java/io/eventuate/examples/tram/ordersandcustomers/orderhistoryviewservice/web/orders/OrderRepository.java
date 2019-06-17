package io.eventuate.examples.tram.ordersandcustomers.orderhistoryviewservice.web.orders;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
