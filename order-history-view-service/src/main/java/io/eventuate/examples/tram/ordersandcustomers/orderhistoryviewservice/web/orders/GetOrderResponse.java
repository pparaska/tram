package io.eventuate.examples.tram.ordersandcustomers.orderhistoryviewservice.web.orders;


import io.eventuate.examples.tram.ordersandcustomers.commondomain.OrderDetails;

public class GetOrderResponse {
  private Long orderId;
  private OrderDetails orderDetails;

  public GetOrderResponse() {
  }

  public GetOrderResponse(Long orderId, OrderDetails orderDetails) {
    this.orderId = orderId;
    this.orderDetails = orderDetails;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public OrderDetails getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(OrderDetails orderDetails) {
    this.orderDetails = orderDetails;
  }
}
