package com.gcu.data;

import java.util.List;
/**
 * Data Access Interface for all Data Access Objects.
 * @author Mason Blaut
 * @version 1.0
 * @param <T> Generic parameter for proper interface initialization.
 */
public interface DataAccessInterface<T> {
	public List<T> findAll();
	public T findById(String id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
