package by.aghmi.control;

import by.aghmi.model.RetType;

public interface Mapper {
	public void create(RetType rtype) throws Exception;
	public void update(RetType rtype);
	public RetType getByID(RetType rtype);
	public void delete(RetType rtype);
	//TO ADD
}
