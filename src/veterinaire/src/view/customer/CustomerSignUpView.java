package veterinaire.src.view.customer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import veterinaire.src.controller.IController;
import veterinaire.src.controller.customer.CustomerController;
import veterinaire.src.controller.home.WelcomeController;
import veterinaire.src.view.IView;

public class CustomerSignUpView extends JFrame implements IView {
	
	  private static final String VIEW_TITLE = "Inscription";

	  private CustomerController controller;
	  private JPanel panel;
	  
	  public CustomerSignUpView(CustomerController controller) {
	    super(VIEW_TITLE);
	    this.initialize();
	    this.controller = controller;
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
		  // Create a panel for the form components
		  JPanel formPanel = new JPanel();
		  this.panel = formPanel;
		  this.add(formPanel, BorderLayout.CENTER);

		  // Set up the layout manager for the form panel
		  formPanel.setLayout(new GridBagLayout());
		  GridBagConstraints constraints = new GridBagConstraints();
		  constraints.insets = new Insets(5, 5, 5, 5);

		  // Add a label and a text field for the name
		  constraints.gridx = 0;
		  constraints.gridy = 0;
		  formPanel.add(new JLabel("Nom: "), constraints);
		  constraints.gridx = 1;
		  JTextField nameField = new JTextField(20);
		  formPanel.add(nameField, constraints);

		  // Add a label and a text field for the first name
		  constraints.gridx = 0;
		  constraints.gridy = 1;
		  formPanel.add(new JLabel("Prénom: "), constraints);
		  constraints.gridx = 1;
		  JTextField firstNameField = new JTextField(20);
		  formPanel.add(firstNameField, constraints);

		  // Add a label and a text field for the phone number
		  constraints.gridx = 0;
		  constraints.gridy = 2;
		  formPanel.add(new JLabel("Téléphone: "), constraints);
		  constraints.gridx = 1;
		  JTextField phoneNumberField = new JTextField(20);
		  formPanel.add(phoneNumberField, constraints);

		  // Add a label and a text field for the email
		  constraints.gridx = 0;
		  constraints.gridy = 3;
		  formPanel.add(new JLabel("Email: "), constraints);
		  constraints.gridx = 1;
		  JTextField emailField = new JTextField(20);
		  formPanel.add(emailField, constraints);
		  
		  // Add a submit button
		  constraints.gridx = 0;
		  constraints.gridy = 4;
		  constraints.gridwidth = 2;
		  constraints.anchor = GridBagConstraints.CENTER;
		  JButton submitButton = new JButton("Envoyer");
		  formPanel.add(submitButton, constraints);
		  submitButton.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent e) {
				    String name = nameField.getText();
				    if (name == null || name.trim().isEmpty()) {
				      name = "NULL";
				    }
				    String firstName = firstNameField.getText();
				    if (firstName == null || firstName.trim().isEmpty()) {
				      firstName = "NULL";
				    }
				    String phoneNumber = phoneNumberField.getText();
				    if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
				      phoneNumber = "NULL";
				    }
				    String email = emailField.getText();
				    if (email == null || email.trim().isEmpty()) {
				      email = "NULL";
				    }
				    controller.processForm(name, firstName, phoneNumber, email);
				    
				    // Close window
		            dispose();
		            
		            // Returns to the main menu
		            IController appController = new WelcomeController();
		    		appController.startApplication(null);
				    
				  }
			});
		  
		}
	  
	  public void confirmInscription() {
		  // Display the "Success!" message in a pop-up window
		  JOptionPane.showMessageDialog(null, "Succès!");
		}





	}
