package pl.edu.pk.middle.dao;



import java.io.Serializable;
import java.util.List;

public interface GenericDao <E extends Serializable, R extends Serializable> {
	public R save(E object);

	public E get(R id);

	public List<E> find(String query);

	public List<E> findAll();

	public void update(E e);

	public E load(R id);

	public int count();

	public void deleteAll();

	public void deleteById(R id);
	
	public void delete(E object);
	
	public void persist(E object);
	
	public void refresh(E object);
	
	public void flush();
}
