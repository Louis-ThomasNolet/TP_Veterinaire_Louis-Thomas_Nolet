package veterinaire.src.controller.dog;

import java.util.List;

import veterinaire.src.controller.customer.CustomerDTOForList;

public class DogDTOForCreate {
	final int ID;
	final String NAME;
	final String BREED;
	final List<CustomerDTOForList> OWNER;
	
	private DogController controller = new DogController();
	
	public DogDTOForCreate(String name, String breed, List<CustomerDTOForList> ownerDTOList) {
		if(controller.getList().size() > 0) {
			this.ID = controller.getList().get(controller.getList().size() - 1).ID + 1;
		}
		else {
			this.ID = 1;
		}
		this.NAME = name;
		this.BREED = breed;
		this.OWNER = ownerDTOList;
	}
}
