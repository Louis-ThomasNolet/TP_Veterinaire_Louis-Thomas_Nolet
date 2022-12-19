package veterinaire.src.view.dog;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import veterinaire.src.controller.IController;
import veterinaire.src.controller.customer.CustomerController;
import veterinaire.src.controller.customer.CustomerDTOForList;
import veterinaire.src.controller.dog.DogController;
import veterinaire.src.controller.home.WelcomeController;
import veterinaire.src.view.IView;

public class DogSignUpView extends JFrame implements IView{

	private DogController controller;
	private static final String VIEW_TITLE = "Inscription d'un chien";	
	
	public DogSignUpView(DogController dogController) {
		super(VIEW_TITLE);
		this.initialize();
		this.controller = dogController;
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
	            IController appController = new WelcomeController();
	    		appController.startApplication(null);
	        }
	    });

	  }
	
	private void setUpComponents() {
		// Set up a panel to hold the form elements
	    JPanel formPanel = new JPanel();
	    formPanel.setLayout(new GridBagLayout());

	    // Set up a label and a text field for the dog's name
	    JLabel nameLabel = new JLabel("Nom:");
	    JTextField nameField = new JTextField(20);

	    // Set the `gridy` value to 0 for the label and text field
	    GridBagConstraints nameConstraints = new GridBagConstraints();
	    nameConstraints.gridy = 0;
	    formPanel.add(nameLabel, nameConstraints);
	    formPanel.add(nameField, nameConstraints);

	    // Set up a label and a text field for the dog's breed
	    JLabel breedLabel = new JLabel("Race:");
	    JTextField breedField = new JTextField(20);

	    // Set the `gridy` value to 1 for the label and text field
	    GridBagConstraints breedConstraints = new GridBagConstraints();
	    breedConstraints.gridy = 1;
	    formPanel.add(breedLabel, breedConstraints);
	    formPanel.add(breedField, breedConstraints);

	    // Set up a label and a dropdown list for selecting the dog's owner
	    JLabel ownerLabel = new JLabel("Propriétaire:");
	    JComboBox<String> ownerList = new JComboBox<>();
	    CustomerDTOForList[] owners = controller.getOwnerList();
	    String[] ownerNames = {};
	    for(CustomerDTOForList customer: owners) {
	        ownerNames = append(ownerNames, customer);
	    }

	    if (owners != null && owners.length > 0) {
	        ownerList.setModel(new DefaultComboBoxModel<>(ownerNames));
	    } else {
	        ownerList.addItem("Aucun propriétaire disponible");
	    }

	    // Set the `gridy` value to 2 for the label and dropdown list
	    GridBagConstraints ownerConstraints = new GridBagConstraints();
	    ownerConstraints.gridy = 2;
	    formPanel.add(ownerLabel, ownerConstraints);
	    formPanel.add(ownerList, ownerConstraints); 

	    // Add a submit button
	    if (owners != null && owners.length > 0) {
	    	JButton submitButton = new JButton("Inscrire");
		    submitButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            // Retrieve the values of the form elements
		            String name = nameField.getText();
		            String breed = breedField.getText();
		            String owner = (String) ownerList.getSelectedItem();

		            System.out.println(owner);
		            
		            // Send the values to the controller
		            controller.signUpDog(name, breed, owner);
		            
		            // Close window
		            dispose();
		            
		            // Returns to the main menu
		            IController appController = new WelcomeController();
		    		appController.startApplication(null);
		        }
		    });

		    // Set the `gridy` value to 3 for the submit button
		    GridBagConstraints submitConstraints = new GridBagConstraints();
		    submitConstraints.gridy = 3;
		    formPanel.add(submitButton, submitConstraints);
	    } else {
	    	JButton submitButton = new JButton("Inscrire un client");
		    submitButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	dispose();
		        	
		            IController appController = new CustomerController();
		            appController.startApplication("form");
		        }
		    });

		    // Set the `gridy` value to 3 for the submit button
		    GridBagConstraints submitConstraints = new GridBagConstraints();
		    submitConstraints.gridy = 3;
		    formPanel.add(submitButton, submitConstraints);
	    }

	    

		// Add the form panel to the window
		this.add(formPanel);


	}

	private String[] append(String[] ownerNames, CustomerDTOForList customer) {
		String ownerName = customer.getNAME() + " " + customer.getFIRST_NAME();
		// Check if the list is null or empty
	    if (ownerNames == null || ownerNames.length == 0) {
	        // If the list is null or empty, return a new array with the customer as the only element
	        return new String[] { ownerName };
	    } else {
	        // If the list is not empty, create a new array with an extra element and copy the elements from the old array
	        String[] newList = new String[ownerNames.length + 1];
	        System.arraycopy(ownerNames, 0, newList, 0, ownerNames.length);
	        // Add the customer to the last element of the new array
	        newList[ownerNames.length] = ownerName;
	        // Return the new array
	        return newList;
	    }
	}

	public void confirmInscription() {
		  // Display the "Success!" message in a pop-up window
		  JOptionPane.showMessageDialog(null, "Success!");
		}

}
