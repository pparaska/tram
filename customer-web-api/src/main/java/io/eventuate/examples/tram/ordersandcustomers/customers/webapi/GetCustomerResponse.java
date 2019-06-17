package io.eventuate.examples.tram.ordersandcustomers.customers.webapi;

import io.eventuate.examples.tram.ordersandcustomers.commondomain.Money;

public class GetCustomerResponse {
	  private Long customerId;
	  private Money creditLimit;

	  public GetCustomerResponse() {
	  }

	  public GetCustomerResponse(Long customerId, Money creditLimit) {
	    this.customerId = customerId;
	    this.creditLimit = creditLimit;
	  }

	  public Long getCustomerId() {
	    return customerId;
	  }

	  public void setCustomerId(Long customerId) {
	    this.customerId = customerId;
	  }

	  public Money getCreditLimit() {
	    return creditLimit;
	  }

	  public void setCreditLimit(Money creditLimit) {
	    this.creditLimit = creditLimit;
	  }
	}