package unq.poo2.shapeShifter;

import java.util.List;

public interface IShapeShifter {

	
	public IShapeShifter compose(IShapeShifter ISS);
	
	public int deepest();
	
	public IShapeShifter flat();
	
	public List<Integer> values();
	
	
}
