package unq.poo2.compras;

public class Product {

	float price;
	String name;
	
	public Product(float price, String name) {
		this.price = price;
		this.name = name;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
}
