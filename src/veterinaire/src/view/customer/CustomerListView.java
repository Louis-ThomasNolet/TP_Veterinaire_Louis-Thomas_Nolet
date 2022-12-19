package veterinaire.src.view.customer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import veterinaire.src.controller.IController;
import veterinaire.src.controller.customer.CustomerController;
import veterinaire.src.controller.customer.CustomerDTOForList;
import veterinaire.src.controller.customer.ProfileController;
import veterinaire.src.controller.home.WelcomeController;
import veterinaire.src.view.IView;

public class CustomerListView extends JFrame implements IView {
	
	  private static final String VIEW_TITLE = "Liste Clients";

	  private CustomerController controller;
	  private DefaultTableModel model;
	  private JTable table;
	  public CustomerListView(CustomerController controller) {
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
		  // Create a table model to hold the data for the table
		  DefaultTableModel model = new DefaultTableModel();
		  this.model = model;
		  // Add columns to the table model
		  model.addColumn("Id Client");
		  model.addColumn("Nom");
		  model.addColumn("Prénom");
		  model.addColumn("Téléphone");
		  
		  
		  JTextField searchField = new JTextField();
		  this.add(searchField, BorderLayout.NORTH);
		  
		  
		  // Create a table using the table model
		  JTable table = new JTable(model);
		  this.table = table;
		  // Add the table to a scroll pane so that it can be scrolled if there are too many rows to fit on the screen
		  JScrollPane scrollPane = new JScrollPane(table);

		  // Add the scroll pane to the frame
		  this.add(scrollPane);
		  
		  
		  
		  for(CustomerDTOForList customer : controller.getList()){
			  addRow(customer);
		  }
		  table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      // Get the row index of the clicked cell
			      int row = table.rowAtPoint(e.getPoint());

			      // Call the customerProfile() method with the customer ID as an argument
			      CustomerDTOForList customer = controller.getList().get(row);
			      
			      // Close window
			      dispose();
			      
			      ProfileController appController = new ProfileController();
			      appController.startApplication(customer);
			    }
			  }
			});
		  
		  
		  searchField.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        // Get the search query from the search field
			        String query = searchField.getText();
			        // Call the searchCustomers() method of the controller with the query as an argument
			        List<CustomerDTOForList> searchResults = controller.searchCustomers(query);
			        // Clear the table
			        model.setRowCount(0);
			        // Add the search results to the table
			        for (CustomerDTOForList customer : searchResults) {
			            addRow(customer);
			        }
			    }
			});
		  
		  
		  searchField.addFocusListener(new FocusAdapter() {
			    @Override
			    public void focusLost(FocusEvent e) {
			        // Clear the search field and refresh the table with all customers
			        searchField.setText("");
			        model.setRowCount(0);
			        for (CustomerDTOForList customer : controller.getList()) {
			            addRow(customer);
			        }
			    }
			});


		}
	  
	  public void addRow(CustomerDTOForList entry) {

		  // Get the table model
		  DefaultTableModel model = (DefaultTableModel) table.getModel();

		  // Create an array with the values from the entry object
		  Object[] rowData = {entry.getID(), entry.getNAME(), entry.getFIRST_NAME(), entry.getPHONE_NUMBER()};

		  // Add the new row to the table model
		  model.addRow(rowData);
		}


	}

