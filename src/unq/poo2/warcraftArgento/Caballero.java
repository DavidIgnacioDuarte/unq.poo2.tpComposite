package unq.poo2.warcraftArgento;

public class Caballero extends TipoDePersonaje{

	
	private Mapa mapa;
	private Integer posicionX;
	private Integer posicionY;

	
	public Caballero(Mapa mapa, Integer posicionX, Integer posicionY) {
		this.mapa = mapa;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	
	
	public void moverA(Integer nuevaPosicionX, Integer nuevaPosicionY) {
		while (this.posicionX != nuevaPosicionX && this.posicionY != nuevaPosicionY ) {
			this.moverUnaPosicionHacia(nuevaPosicionX, nuevaPosicionY);
		}
	}
	
	
	public void moverUnaPosicionHacia(Integer nuevaPosicionX, Integer nuevaPosicionY) {
		//Implementar la logica del ZigZgag
		if(nuevaPosicionX != this.posicionX) {
			this.moverseEnZigZagXHacia(nuevaPosicionX);
		} else {
			this.moverseEnZigZagYHacia(nuevaPosicionY);
		}
	}
	
	
	private void moverseEnZigZagXHacia(Integer nuevaPosicionX) {
		if(nuevaPosicionX > this.posicionX ) {
			this.posicionX ++;
		}
		else {
			this.posicionX --;
		}
	}

	
	private void moverseEnZigZagYHacia(Integer nuevaPosicionY) {
		if(nuevaPosicionY > this.posicionX ) {
			this.posicionX ++;
		}
		else {
			this.posicionX --;
		}
	}
	
}
