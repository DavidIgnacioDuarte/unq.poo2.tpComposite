package unq.poo2.compras;

public class SpecialProduct extends Product{
	
	public SpecialProduct(float price, String name) {
		super(price, name);
	}
	
	@Override
	public float getPrice() {
		return this.price;
	}
	
}
