package unq.poo2.warcraftArgento;

public class Casillero {
	
	private boolean esCamino = false;
	private boolean tieneEnemigo = false;

	
	public boolean esCamino() {
		return this.esCamino;
	}
	
	public void convertirEnCamino() {
		this.esCamino = true;
	}

	public boolean tieneEnemigo() {
		return this.tieneEnemigo;
	}

	public void agregarEnemigo() {
		this.tieneEnemigo = true;
	}

}
