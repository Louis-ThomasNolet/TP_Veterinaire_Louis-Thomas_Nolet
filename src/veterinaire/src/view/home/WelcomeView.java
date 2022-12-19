package veterinaire.src.view.home;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import veterinaire.src.controller.IController;
import veterinaire.src.controller.customer.CustomerController;
import veterinaire.src.controller.dog.DogController;
import veterinaire.src.util.image.ImageUtil;
import veterinaire.src.view.IView;

public class WelcomeView extends JFrame implements IView { 
	private static final String VIEW_TITLE = "Nos amis les chiens";
	private static final String WELCOME_MESSAGE = "Bienvenue !";
	private final String IMAGE_URL = "https://hips.hearstapps.com/ghk.h-cdn.co/assets/16/15/bearded-collie.jpg?resize=400:*";
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	private static URL imageURL;
	private IController controller;		
	
	public WelcomeView(IController controller) {
		super(VIEW_TITLE);
		
		this.controller = controller;
		try {
			this.imageURL = new URL("https://hips.hearstapps.com/ghk.h-cdn.co/assets/16/15/bearded-collie.jpg?resize=400:*");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		this.initialize();
		this.setUpComponents();
	}
	
	

	@Override
	public void display() {
		this.setVisible(true);
	}
	
	private void initialize() {
		this.setSize(DEFAULT_SIZE);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	private void setUpComponents() {
		this.setUpWelcomePanel();
		this.setUpActionPanel();
	}

	private void setUpWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		this.add(welcomePanel, BorderLayout.CENTER);  
		welcomePanel.setLayout(new BorderLayout());   
		addWelcomePicture(welcomePanel);		
		addWelcomeMessage(welcomePanel);		
	}

	private void addWelcomeMessage(JPanel welcomePanel) {
		JLabel welcomeMessage = new JLabel(WELCOME_MESSAGE, SwingConstants.CENTER);
		welcomePanel.add(welcomeMessage, BorderLayout.NORTH);
	}

	private void addWelcomePicture(JPanel welcomePanel) {
		ImageIcon image = ImageUtil.getImageIcon(imageURL);
		JLabel welcomePicture = new JLabel(image);		
		welcomePanel.add(welcomePicture, BorderLayout.CENTER);  
	}

	private void setUpActionPanel() {
	    // Create a panel for the action buttons
	    JPanel actionPanel = new JPanel();

	    // Create a button to open the form
	    JButton openFormButton = new JButton("S'inscrire");
	    openFormButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	// Close window
	            dispose();
	        	
	            // Open the form when the button is clicked
	            IController appController = new CustomerController();
	            appController.startApplication("form");
	        }
	    });

	    // Add the button to the action panel
	    actionPanel.add(openFormButton);

	    // Create a button to consult the list
	    JButton consultListButton = new JButton("Clients");
	    consultListButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	 // Close window
	            dispose();
	            
	            // Open the list when the button is clicked
	            IController appController = new CustomerController();
	            appController.startApplication("list");
	        }
	    });

	    // Add the button to the action panel
	    actionPanel.add(consultListButton);

	    // Create a button to sign up a dog
	    JButton signUpDogButton = new JButton("Inscrire un chien");
	    signUpDogButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	// Close window
	            dispose();
	        	
	            // Open the form to sign up a dog when the button is clicked
	            DogController dogController = new DogController();
	            dogController.startApplication("form");
	        }
	    });

	    // Add the button to the action panel
	    actionPanel.add(signUpDogButton);
	    
	    
	 // Create a button to consult the list of dogs
	    JButton consultDogListButton = new JButton("Chiens");
	    consultDogListButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Close window
	            dispose();

	            // Open the list of dogs when the button is clicked
	            IController appController =  new DogController();
	            appController.startApplication("list");
	        }
	    });

	    // Add the button to the action panel
	    actionPanel.add(consultDogListButton);


	    // Add the action panel to the frame
	    this.add(actionPanel, BorderLayout.SOUTH);
	}


		
	

}
