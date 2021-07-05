package unq.poo2.shapeShifter;

import java.util.Arrays;
import java.util.List;

public class ShapeShifterLeaf implements IShapeShifter {
	
	Integer value;
	
	
	public ShapeShifterLeaf(Integer value) {
		this.value = value;
	}
	
	
	public IShapeShifter compose(IShapeShifter ss) {
		ShapeShifter newShapeShifter = new ShapeShifter();
		newShapeShifter.addShapeShifter(this);
		newShapeShifter.addShapeShifter(ss);
		return newShapeShifter;
	}

	
	public int deepest() {
		return 0;
	}

	
	public IShapeShifter flat() {
		return this;
	}

	
	public List<Integer> values() {
		return Arrays.asList(this.value);
	}
	
}
