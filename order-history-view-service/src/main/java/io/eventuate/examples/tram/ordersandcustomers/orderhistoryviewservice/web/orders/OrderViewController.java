package io.eventuate.examples.tram.ordersandcustomers.orderhistoryviewservice.web.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderViewController {

  // private OrderService orderService;
  private OrderRepository orderViewRepository;

  @Autowired
  public OrderViewController(OrderRepository orderRepository) {
        this.orderViewRepository = orderRepository;
  }
 

  @RequestMapping(value="/orders/{orderId}", method= RequestMethod.GET)
  public ResponseEntity<GetOrderResponse> getOrder(@PathVariable Long orderId) {

    Order order = orderViewRepository.findOne(orderId);

    if (order == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(new GetOrderResponse(order.getId(), order.getOrderDetails()), HttpStatus.OK);
    }
  }


}
