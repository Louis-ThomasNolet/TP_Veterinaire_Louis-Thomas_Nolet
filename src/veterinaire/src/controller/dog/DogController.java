package veterinaire.src.controller.dog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import veterinaire.src.controller.IController;
import veterinaire.src.controller.customer.CustomerController;
import veterinaire.src.controller.customer.CustomerDTOForList;
import veterinaire.src.controller.home.seeder.DataSeeder;
import veterinaire.src.model.Dog;
import veterinaire.src.repository.IRepository;
import veterinaire.src.repository.Repository;
import veterinaire.src.view.IView;
import veterinaire.src.view.dog.DogListView;
import veterinaire.src.view.dog.DogSignUpView;

public class DogController implements IController{
	private static  boolean hasBeenStarted = false;
	private CustomerController customerController = new CustomerController();
	public static DogConverter converter = new DogConverter();
	public static IRepository repository = new Repository();
	public IView view;
	
	@Override
    public void startApplication(String app) {
		if(!hasBeenStarted) {
			DataSeeder seeder = new DataSeeder();
			List<Dog> dogs = seeder.seedDogData();
			for(Dog dog : dogs) {
				dog.setId(repository.getId());
				repository.add(dog);
			}
			hasBeenStarted = true;
		}
		
		if(app == "form") {
			IView view = new DogSignUpView(this);
			this.view =  view;
			view.display();
		}
		else if(app == "list") {
			IView view = new DogListView(this);
			this.view =  view;
			view.display();
		}
    }

	public CustomerDTOForList[] getOwnerList() {
		CustomerDTOForList[] list = {};
		for(CustomerDTOForList customer : customerController.getList())
			list = append(list, customer);
		return list;
	}

	private CustomerDTOForList[] append(CustomerDTOForList[] list, CustomerDTOForList customer) {
	    // Check if the list is null or empty
	    if (list == null || list.length == 0) {
	        // If the list is null or empty, return a new array with the customer as the only element
	        return new CustomerDTOForList[] { customer };
	    } else {
	        // If the list is not empty, create a new array with an extra element and copy the elements from the old array
	        CustomerDTOForList[] newList = new CustomerDTOForList[list.length + 1];
	        System.arraycopy(list, 0, newList, 0, list.length);
	        // Add the customer to the last element of the new array
	        newList[list.length] = customer;
	        // Return the new array
	        return newList;
	    }
	}

	public void signUpDog(String name, String breed, String ownerString) {
		List<CustomerDTOForList> ownerDTOList = customerController.searchCustomers(ownerString);
		Dog dog = (Dog) converter.convertForCreate(new DogDTOForCreate(name, breed, ownerDTOList));
		if(dog.isOwnerValid()) {
			repository.add(dog);
			((DogSignUpView) view).confirmInscription();
		}
		
		
	}

	public List<DogDTOForList> getList() {
		Collection<Object> dogList = repository.getList();
		List<DogDTOForList> dogs = new ArrayList<>();
		for(Object dog : dogList) {
			dogs.add(converter.convertForList((Dog) dog));
		}
		return dogs;
	}

	public List<DogDTOForList> searchDogs(String query) {
		// Convert the search query to lower case to make the search case-insensitive
		  query = query.toLowerCase();
		  
		  // Removes the spaces
		  query = query.replaceAll(" ", "");


		  
		  // Initialize an empty list to hold the search results
		  List<DogDTOForList> searchResults = new ArrayList<>();

		  // Iterate over the list of customers
		  for (DogDTOForList dog : getList()) {
		    // Get the customer's name, first name, and id and convert them to lower case
		    String name = dog.getNAME().toLowerCase();
		    String breed = dog.getBREED().toLowerCase();
		    String id = Integer.toString(dog.getID()).toLowerCase();

		    String nameBreed = name + breed;
		    String breedName = breed + name;
		    // Check if the search query appears in the customer's name, first name, or id
		    if (nameBreed.contains(query) || breedName.contains(query) || id.contains(query)) {
		      // If the query appears in any of these fields, add the customer to the search results list
		      searchResults.add(dog);
		    }
		  }

		  // Return the search results list
		  return searchResults;
		}
	}



