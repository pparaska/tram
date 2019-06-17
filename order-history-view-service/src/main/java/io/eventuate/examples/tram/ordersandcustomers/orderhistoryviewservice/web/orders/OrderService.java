package io.eventuate.examples.tram.ordersandcustomers.orderhistoryviewservice.web.orders;

import static java.util.Collections.singletonList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import io.eventuate.examples.tram.ordersandcustomers.commondomain.OrderApprovedEvent;
import io.eventuate.examples.tram.ordersandcustomers.commondomain.OrderDetails;
import io.eventuate.examples.tram.ordersandcustomers.commondomain.OrderRejectedEvent;
import io.eventuate.tram.events.ResultWithEvents;
import io.eventuate.tram.events.publisher.DomainEventPublisher;

public class OrderService {

  @Autowired
  private DomainEventPublisher domainEventPublisher;

  @Autowired
  private OrderRepository orderRepository;

  @Transactional
  public Order createOrder(OrderDetails orderDetails) {
    ResultWithEvents<Order> orderWithEvents = Order.createOrder(orderDetails);
    Order order = orderWithEvents.result;
    orderRepository.save(order);
    domainEventPublisher.publish(Order.class, order.getId(), orderWithEvents.events);
    return order;
  }

  public void approveOrder(Long orderId) {
    Order order = orderRepository.findOne(orderId);
    order.noteCreditReserved();
    domainEventPublisher.publish(Order.class,
            orderId, singletonList(new OrderApprovedEvent(order.getOrderDetails())));
  }

  public void rejectOrder(Long orderId) {
    Order order = orderRepository.findOne(orderId);
    order.noteCreditReservationFailed();
    domainEventPublisher.publish(Order.class,
            orderId, singletonList(new OrderRejectedEvent(order.getOrderDetails())));
  }
}
