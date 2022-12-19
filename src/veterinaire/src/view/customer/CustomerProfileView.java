package veterinaire.src.view.customer;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import veterinaire.src.controller.IController;
import veterinaire.src.controller.customer.CustomerController;
import veterinaire.src.view.IView;

public class CustomerProfileView extends JFrame implements IView{
	
	private static final String VIEW_TITLE = "Profile";
	
	private int id;
	private String name;
	private String firstName;
	private String phoneNumber;
	private String email;
	
	public CustomerProfileView(int id, String name, String firstName, String phoneNumber, String email) {
			super(VIEW_TITLE);
			this.id = id;
			this.name = name;
			this.firstName = firstName;
			this.phoneNumber = phoneNumber;
			this.email = email;
			
			
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
	            IController appController = new CustomerController();
	    		appController.startApplication("list");
	        }
	    });

	  }
	
	
	private void setUpComponents() {
		  
		  // Create a list model to hold the customer's information
		  DefaultListModel<String> model = new DefaultListModel<>();
		  model.addElement("Nom: " + name);
		  model.addElement("Prénom: " + firstName);
		  model.addElement("Téléphone: " + phoneNumber);
		  model.addElement("Email: " + email);
		  
		  // Create a list to display the customer's information
		  JList<String> list = new JList<>(model);
		  
		  // Add the list to the frame
		  this.add(new JScrollPane(list));
		}


}
