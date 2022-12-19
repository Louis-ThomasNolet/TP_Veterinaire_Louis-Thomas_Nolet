package veterinaire.src.model;

import java.util.List;

import veterinaire.src.controller.customer.CustomerController;
import veterinaire.src.controller.customer.CustomerDTOForList;

public class Dog {
    private int id;
    private String name;
    private String race;
    private Customer owner;

    public Dog(int id, String name, String race, List<CustomerDTOForList> ownerDTOList) {
        this.id = id;
        this.name = name;
        this.race = race; 
        if(ownerDTOList.get(0).getEMAIL() == null)
        	this.owner = new Customer(ownerDTOList.get(0).getID(), ownerDTOList.get(0).getNAME(), ownerDTOList.get(0).getFIRST_NAME(), ownerDTOList.get(0).getPHONE_NUMBER());
        else
        	this.owner = new Customer(ownerDTOList.get(0).getID(), ownerDTOList.get(0).getNAME(), ownerDTOList.get(0).getFIRST_NAME(), ownerDTOList.get(0).getPHONE_NUMBER(), ownerDTOList.get(0).getEMAIL());
    }

    public boolean isOwnerValid() {
    	return CustomerController.repository.searchById(owner.getCustomerId()) != null;
    }

    
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

	public void setId(int id) {
		this.id = id;
	}
}

