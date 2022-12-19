package controller.customer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import veterinaire.src.controller.customer.CustomerController;
import veterinaire.src.controller.customer.CustomerDTOForCreate;
import veterinaire.src.controller.customer.CustomerDTOForList;
import veterinaire.src.model.Customer;
import veterinaire.src.view.customer.CustomerListView;
import veterinaire.src.view.customer.CustomerSignUpView;

public class CustomerControllerTest {
  private CustomerController controller = new CustomerController();
  private CustomerDTOForCreate customerDTO;
  private Customer customer;

  private CustomerSignUpView mockSignUpView = new CustomerSignUpView(controller) {
    // Override methods of the CustomerSignUpView class as needed
  };

  private CustomerListView mockListView = new CustomerListView(controller) {
    // Override methods of the CustomerListView class as needed
  };

  @BeforeEach
  void setUp() {
    customerDTO = new CustomerDTOForCreate(1, "John", "Doe", "1234567890", "john.doe@example.com");
    customer = controller.converter.convertForCreate(customerDTO);
  }

  @Test
  void testStartApplication() {
    controller.startApplication("form");
    assertEquals(mockSignUpView, controller.getView());

    controller.startApplication("list");
    assertEquals(mockListView, controller.getView());
  }
  
  @Test
  void testGetList() {
    controller.repository.add(customer);
    List<CustomerDTOForList> customers = controller.getList();
    assertEquals(1, customers.size());
    assertEquals(customerDTO, customers.get(0));
  }
  
  @Test
  void testSearchCustomers() {
    controller.repository.add(customer);
    List<CustomerDTOForList> customers = controller.searchCustomers("john");
    assertEquals(1, customers.size());
    assertEquals(customerDTO, customers.get(0));
  }
}
