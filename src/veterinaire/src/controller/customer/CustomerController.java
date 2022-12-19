package veterinaire.src.controller.customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import veterinaire.src.controller.IController;
import veterinaire.src.controller.home.seeder.DataSeeder;
import veterinaire.src.model.Customer;
import veterinaire.src.repository.IRepository;
import veterinaire.src.repository.Repository;
import veterinaire.src.view.IView;
import veterinaire.src.view.customer.CustomerListView;
import veterinaire.src.view.customer.CustomerSignUpView;

public class CustomerController implements IController{	
	public static CustomerConverter converter = new CustomerConverter();
	public static IRepository repository = new Repository();
	private IView view;
	public static boolean hasBeenStarted = false;
	
	@Override
	public void startApplication(String app) {;
		if(!hasBeenStarted) {
			DataSeeder seeder = new DataSeeder();
			List<Customer> customers = seeder.seedCustomerData();
			for(Customer customer : customers) {
				customer.setId(repository.getId());
				repository.add(customer);
			}
			hasBeenStarted = true;
		}
		
		if(app == "form") {
			IView view = new CustomerSignUpView(this);
			this.view =  view;
			view.display();
		}
		else if(app == "list") {
			IView view = new CustomerListView(this);
			this.view =  view;
			view.display();
		}
	}

	public void processForm(String name, String firstName, String phoneNumber, String email) {
		Customer customer = converter.convertForCreate(new CustomerDTOForCreate(repository.getId(),name, firstName, phoneNumber, email));
		repository.add(customer);
		if(hasBeenStarted)
			((CustomerSignUpView) getView()).confirmInscription();
	}
	
	public List<CustomerDTOForList> getList() {
		Collection<Object> customerList = repository.getList();
		List<CustomerDTOForList> customers = new ArrayList<>();
		for(Object customer : customerList) {
			customers.add(converter.convertForList((Customer) customer));
		}
		return customers;
	}

	public List<CustomerDTOForList> searchCustomers(String query) {
		  // Convert the search query to lower case to make the search case-insensitive
		  query = query.toLowerCase();
		  
		  // Removes the spaces
		  query = query.replaceAll(" ", "");
		  
		  // Initialize an empty list to hold the search results
		  List<CustomerDTOForList> searchResults = new ArrayList<>();

		  // Iterate over the list of customers
		  for (CustomerDTOForList customer : getList()) {
		    // Get the customer's name, first name, and id and convert them to lower case
		    String name = customer.getNAME().toLowerCase();
		    String firstName = customer.getFIRST_NAME().toLowerCase();
		    String id = Integer.toString(customer.getID()).toLowerCase();

		    String nameFirstName = name + firstName;
		    String firstNameName = firstName + name;
		    // Check if the search query appears in the customer's name, first name, or id
		    if (nameFirstName.contains(query) || firstNameName.contains(query) || id.contains(query)) {
		      // If the query appears in any of these fields, add the customer to the search results list
		      searchResults.add(customer);
		    }
		  }

		  // Return the search results list
		  return searchResults;
		}

	public IView getView() {
		return view;
	}


}
