package veterinaire.src.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repository implements IRepository{

	private  int id;
	private Map<Integer,Object> values;
	
	public Repository() {
		values = new HashMap<>();
		this.id = 1;
	}
	
	@Override
	public void add(Object object) {
		  
		  values.put(this.id, object);
		  this.id++;
		}
	@Override
	public Collection<Object> getList() {
		Collection<Object> list = new ArrayList<>();
		list.addAll(values.values());
		return list;
	}

	@Override
	public int size() {
	  return values.size();
	}


	@Override
	public Object searchById(int id) {
	  return values.get(id);
	}

	@Override
	public int getId() {
		return this.id;
	}
}
