package veterinaire.src.model;

public class Customer {
	  private int customerId;
	  private String name;
	  private String firstName;
	  private String phoneNumber;
	  private String email;

	  public Customer(int customerId, String name, String firstName, String phoneNumber, String email) {
		    if (name == "NULL") {
		      throw new IllegalArgumentException("Name cannot be empty or null");
		    }
		    if (firstName == "NULL") {
			      throw new IllegalArgumentException("First name cannot be empty or null");
			    }
		    this.customerId = customerId;
		    this.name = name;
		    this.firstName = firstName;
		    setPhoneNumber(phoneNumber);
		    setEmail(email);
		  }

		  public Customer(int customerId, String name, String firstName, String phoneNumber) {
			  if (name == "NULL") {
			      throw new IllegalArgumentException("Name cannot be empty or null");
			    }
			    if (firstName == "NULL") {
				      throw new IllegalArgumentException("First name cannot be empty or null");
				    }
		    this.customerId = customerId;
		    this.name = name;
		    this.firstName = firstName;
		    setPhoneNumber(phoneNumber);
		  }

	  public int getCustomerId() {
	    return customerId;
	  }

	  public String getName() {
	    return name;
	  }

	  public String getFirstName() {
	    return firstName;
	  }

	  public String getPhoneNumber() {
	    return phoneNumber;
	  }

	  public String getEmail() {
	    return email;
	  }

	  private boolean isValidPhoneNumber(String phoneNumber) {
	    return phoneNumber.matches("\\d{10}");
	  }

	  private boolean isValidEmail(String email) {
	    return email.contains("@");
	  }

	  private void setPhoneNumber(String phoneNumber) {
	    if (isValidPhoneNumber(phoneNumber)) {
	      this.phoneNumber = phoneNumber;
	    } else {
	      throw new IllegalArgumentException("Invalid phone number");
	    }
	  }

	  private void setEmail(String email) {
	    if (isValidEmail(email)) {
	      this.email = email;
	    } else {
	      throw new IllegalArgumentException("Invalid email address");
	    }
	  }

	  public void setId(int id) {
		this.customerId = id;
		
	}
}