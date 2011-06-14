/** Copyright (c) Canadian Light Source, Inc. All rights reserved.
 *   - see license.txt for details.
 *
 *  Description:
 *     ModelDAO interface.
 *     
 */
package ca.sciencestudio.model.dao;

import java.util.List;

import ca.sciencestudio.model.Model;

/**
 * @author maxweld
 *
 *
 */
public interface ModelDAO<T extends Model> {
	
	public boolean add(T t);
	public boolean add(T t, String facility);
	public boolean edit(T t);
	public boolean remove(Object gid);
	
	public T get(Object gid);
	
	public List<T> getAll();
}