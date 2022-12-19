package veterinaire.src.controller.dog;

import veterinaire.src.model.Customer;

public class DogDTOForList {
	final int ID;
	final String NAME;
	final String BREED;
	final Customer OWNER;
	
	public DogDTOForList(int id, String name, String breed, Customer owner) {
		this.ID = id;
		this.NAME = name;
		this.BREED = breed;
		this.OWNER = owner;
	}

	public int getID() {
		return ID;
	}

	public String getNAME() {
		return NAME;
	}

	public String getBREED() {
		return BREED;
	}

	public Customer getOWNER() {
		return OWNER;
	}
	
	
}
