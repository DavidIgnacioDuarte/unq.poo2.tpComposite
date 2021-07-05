package unq.poo2.shapeShifter;

import java.util.ArrayList;
import java.util.List;

public class ShapeShifter implements IShapeShifter {

	private List<IShapeShifter> shapeShifters;
	
	
	public ShapeShifter() {
		this.shapeShifters = new ArrayList<IShapeShifter>();
	}

	
	public IShapeShifter compose(IShapeShifter ss) {
		ShapeShifter sSRetorno = new ShapeShifter();
		sSRetorno.addShapeShifter(this);
		sSRetorno.addShapeShifter(ss);
		return sSRetorno;
	}

	
	public int deepest() {
		int retorno = 0;
		for(IShapeShifter ss : this.shapeShifters) {
			int sSDepth = 1 + ss.deepest();
			if (sSDepth > retorno) {
				retorno = sSDepth; 
			}
		}
		return retorno;
	}
	
	
	public IShapeShifter flat() {
		ShapeShifter newShapeShifter =  new ShapeShifter();
		for (int x : this.values()) {
			this.shapeShifters.add(new ShapeShifterLeaf(x));
		}
		return newShapeShifter;
	}

	
	public List<Integer> values() {
		List<Integer> valores = new ArrayList<Integer>(); 
		for(IShapeShifter ssActual : this.shapeShifters) {
			valores.addAll(ssActual.values());
		}
		return valores;
	}
	
	
	void addShapeShifter(IShapeShifter ss) {
		this.shapeShifters.add(ss);
	}

}
