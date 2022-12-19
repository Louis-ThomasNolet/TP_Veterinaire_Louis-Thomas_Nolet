package veterinaire.src.repository;

import java.util.Collection;

public interface IRepository {
	public void add(Object object);
	public Collection<Object> getList();
	public int size();
	public Object searchById(int id);
	public int getId();
}
