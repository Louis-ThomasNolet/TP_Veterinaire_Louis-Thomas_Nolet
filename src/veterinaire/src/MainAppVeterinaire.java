package veterinaire.src;

import veterinaire.src.controller.IController;
import veterinaire.src.controller.home.WelcomeController;

public class MainAppVeterinaire {
	public static void main(String[] args) {
		new MainAppVeterinaire();
	}

	public MainAppVeterinaire() {
		this.createControllers();
	}

	private void createControllers() {
		IController appController = new WelcomeController();
		appController.startApplication(null);
	}
}
