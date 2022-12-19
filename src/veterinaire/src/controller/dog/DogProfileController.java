package veterinaire.src.controller.dog;

import veterinaire.src.view.IView;
import veterinaire.src.view.dog.DogProfileView;

public class DogProfileController {
	public void startApplication(DogDTOForList dog){
		IView view = new DogProfileView(dog.ID, dog.NAME, dog.BREED, dog.OWNER.getCustomerId(), dog.OWNER.getName(), dog.OWNER.getFirstName(), dog.OWNER.getPhoneNumber(), dog.OWNER.getEmail());
		view.display();
	}
}
