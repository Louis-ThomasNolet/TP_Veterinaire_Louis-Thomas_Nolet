package veterinaire.src.controller.customer;

import veterinaire.src.model.Customer;

public class CustomerConverter {
	
	public Customer convertForCreate(CustomerDTOForCreate dto) {
		if(dto.EMAIL == "NULL") {
			return new Customer(dto.ID, dto.NAME, dto.FIRST_NAME, dto.PHONE_NUMBER);
		}
		return new Customer(dto.ID, dto.NAME, dto.FIRST_NAME, dto.PHONE_NUMBER, dto.EMAIL);
	}
	
	public CustomerDTOForList convertForList(Customer customer) {
		return new CustomerDTOForList(customer.getCustomerId(), customer.getName(), customer.getFirstName(), customer.getPhoneNumber(), customer.getEmail());
	}
}
