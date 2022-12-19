package veterinaire.src.controller.customer;

public class CustomerDTOForCreate {
	public final int ID;
	public final String NAME;
	public final String FIRST_NAME;
	public final String PHONE_NUMBER;
	public final String EMAIL;
	
	private CustomerController controller = new CustomerController();
	
	
	public CustomerDTOForCreate(int id, String name, String firstName, String phoneNumber, String email) {
	    this.ID = id;
	    this.NAME = name;
	    this.FIRST_NAME = firstName;
	    this.PHONE_NUMBER = phoneNumber;
	    if(email == null) {
	    	this.EMAIL = "";
	    }
	    else {
	    	this.EMAIL = email;
	    }
	    
	  }
}
