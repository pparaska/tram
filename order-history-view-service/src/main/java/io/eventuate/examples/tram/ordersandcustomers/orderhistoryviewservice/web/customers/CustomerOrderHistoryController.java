package io.eventuate.examples.tram.ordersandcustomers.orderhistoryviewservice.web.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOrderHistoryController {

  // private CustomerService customerService;
  private CustomerRepository customerViewRepository;

  @Autowired
  public CustomerOrderHistoryController(CustomerRepository customerViewRepository) {
    //this.customerService = customerService;
    this.customerViewRepository = customerViewRepository;
  }
 

  @RequestMapping(value="/customers/{customerId}", method= RequestMethod.GET)
  public ResponseEntity<GetCustomerResponse> getCustomer(@PathVariable Long customerId) {

    Customer customer = customerViewRepository.findOne(customerId);

    if (customer == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(new GetCustomerResponse(customer.getId(), customer.getCreditLimit()), HttpStatus.OK);
    }
  }


}
