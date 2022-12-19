package veterinaire.src.controller.home;

import veterinaire.src.controller.IController;
import veterinaire.src.controller.customer.CustomerController;
import veterinaire.src.view.IView;
import veterinaire.src.view.home.WelcomeView;

public class WelcomeController implements IController {


	public void startApplication(String app) {;
		// create the customer controller when you start the application
		// this will seed the data and create the repositories
		IController controller = new CustomerController();
		controller.startApplication("");
		IView welcomeView = new WelcomeView(this);
		welcomeView.display();
	}
}
