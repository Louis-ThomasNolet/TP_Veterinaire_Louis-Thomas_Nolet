package veterinaire.src.controller.home.seeder;

import java.util.ArrayList;
import java.util.List;

import veterinaire.src.controller.customer.CustomerConverter;
import veterinaire.src.controller.customer.CustomerDTOForList;
import veterinaire.src.model.Customer;
import veterinaire.src.model.Dog;

public class DataSeeder {
	private Customer customer1 = new Customer(0, "Nolet", "Dany", "4184557846", "dany.nolet@hotmail.com");
    private Customer customer2 = new Customer(0, "Nolet", "Louis-Thomas", "5815788821", "louis.thomas.nolet@icloud.com");
    private Customer customer3 = new Customer(0, "Levasseur", "Chantal", "4184557841", "levasseurchantal@outlook.ca");
	
   
	public DataSeeder() {
		
	}
	
  public List<Customer> seedCustomerData() {
    List<Customer> customers = new ArrayList<Customer>();
    
    
    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);

	return customers;
  }
  
  public List<Dog> seedDogData() {
	    List<Dog> dogs = new ArrayList<Dog>();
	    
	    CustomerConverter converter = new CustomerConverter();
	    
	    List<CustomerDTOForList> owner = new ArrayList<>();
	    
	    owner.add(converter.convertForList(customer1));
	    Dog dog1 = new Dog(0,"Gustave" ,"Morky" , owner);
	    
	    owner.clear();
	    owner.add(converter.convertForList(customer2));
	    Dog dog2 = new Dog(0, "Carmen", "Morky", owner);
	    
	    owner.clear();
	    owner.add(converter.convertForList(customer3));
	    Dog dog3 = new Dog(0, "Ralph", "Labrador", owner);
	    
	    dogs.add(dog1);
	    dogs.add(dog2);
	    dogs.add(dog3);

		return dogs;
	  }
}

