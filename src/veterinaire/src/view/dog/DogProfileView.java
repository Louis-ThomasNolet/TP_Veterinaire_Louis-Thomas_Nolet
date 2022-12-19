package veterinaire.src.view.dog;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import veterinaire.src.controller.IController;
import veterinaire.src.controller.dog.DogController;
import veterinaire.src.view.IView;

public class DogProfileView extends JFrame implements IView{
	
	private static final String VIEW_TITLE = "Profile";
	
	private int id;
	private String name;
	private String breed;
	private int ownerId;
	private String ownerName;
	private String ownerFirstName;
	private String ownerPhoneNumber;
	private String ownerEmail;
	
	public DogProfileView(int id, String name, String breed, int ownerId, String ownerName, String ownerFirstName, String ownerPhoneNumber, String ownerEmail) {
			super(VIEW_TITLE);
			this.id = id;
			this.name = name;
			this.breed = breed;
			this.ownerId = ownerId;
			this.ownerName = ownerName;
			this.ownerFirstName = ownerFirstName;
			this.ownerPhoneNumber = ownerPhoneNumber;
			this.ownerEmail = ownerEmail;
			
			this.initialize();
			this.setUpComponents();
	}

	@Override
	public void display() {
		this.setVisible(true);
	}
	
	private void initialize() {
	    this.setSize(new Dimension(600, 400));
	    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    this.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	        	// Close window
	            dispose();
	            
	            // Returns to the main menu
	            IController appController = new DogController();
	    		appController.startApplication("list");
	        }
	    });

	  }
	
	
	private void setUpComponents() {
		  
		  // Create a list model to hold the customer's information
		  DefaultListModel<String> model = new DefaultListModel<>();
		  model.addElement("Id: " + id);
		  model.addElement("Nom: " + name);
		  model.addElement("Race: " + breed);
		  model.addElement("");
		  model.addElement("Id propriétaire: " + ownerId);
		  model.addElement("Nom propriétaire: " + ownerName);
		  model.addElement("Prénom propriétairee: " + ownerFirstName);
		  model.addElement("Téléphone propriétaire: " + ownerPhoneNumber);
		  model.addElement("Email propriétaire: " + ownerEmail);
		  // Create a list to display the customer's information
		  JList<String> list = new JList<>(model);
		  
		  // Add the list to the frame
		  this.add(new JScrollPane(list));
		}


}

