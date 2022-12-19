package veterinaire.src.controller.customer;

import veterinaire.src.view.IView;
import veterinaire.src.view.customer.CustomerProfileView;

public class ProfileController{
	
	public void startApplication(CustomerDTOForList customer) {
		IView view = new CustomerProfileView(customer.getID(), customer.getNAME(), customer.getFIRST_NAME(), customer.getPHONE_NUMBER(), customer.getEMAIL());
		view.display();
	}
}
