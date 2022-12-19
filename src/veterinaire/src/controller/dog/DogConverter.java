package veterinaire.src.controller.dog;

import veterinaire.src.model.Dog;

public class DogConverter {
	

	public Dog convertForCreate(DogDTOForCreate dto) {
		return new Dog(dto.ID, dto.NAME, dto.BREED, dto.OWNER);
	}
	
	public DogDTOForList convertForList(Dog dog) {
		return new DogDTOForList(dog.getId(), dog.getName(), dog.getRace(), dog.getOwner());
	}
}
