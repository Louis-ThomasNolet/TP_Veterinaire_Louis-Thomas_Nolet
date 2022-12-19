package veterinaire.src.controller.customer;

public class CustomerDTOForList {
	final int ID;
	final String NAME;
	final String FIRST_NAME;
	final String PHONE_NUMBER;
	final String EMAIL;
	
	
	public CustomerDTOForList(int customerId, String name, String firstName, String phoneNumber, String email) {
		
		this.ID = customerId;
		this.NAME = name;
		this.FIRST_NAME = firstName;
		this.PHONE_NUMBER = phoneNumber;
		this.EMAIL = email;
	}


	public int getID() {
		return ID;
	}


	public String getNAME() {
		return NAME;
	}


	public String getFIRST_NAME() {
		return FIRST_NAME;
	}


	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}


	public String getEMAIL() {
		return EMAIL;
	}
	
	

}
