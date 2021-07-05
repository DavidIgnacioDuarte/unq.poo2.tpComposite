package unq.poo2.compras;

import java.util.List;

public class CarroDeCompras {

	List<Product> elements;
	
	public CarroDeCompras(){
		
	}
	
	public List<Product> getElements() {
		return this.elements;
	}
	
	public int totalRounded() {
		return (int) this.total();
	}
	
	public float total() {
		float total = 0;
		for(Product element : this.elements) {
			total =+ element.getPrice();
		}
		return total;
	}

	private void setElements(List<Product> elements) {
		this.elements = elements;
	}
	
}
