package com.classicModels.Interface;

import java.util.List;

public interface CMInterface {
	
	public void update(Object source, Object cible);
	public List<?> listAll();
	public Object getRecord(Object o);
	public void displayAll();

}
