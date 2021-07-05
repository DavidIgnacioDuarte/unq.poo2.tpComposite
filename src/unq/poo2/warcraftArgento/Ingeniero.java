package unq.poo2.warcraftArgento;

public class Ingeniero extends TipoDePersonaje {
	
	private Mapa mapa;
	private Integer posicionX;
	private Integer posicionY;
	private Integer lajas = 10;

	public Ingeniero(Mapa mapa, Integer posicionX, Integer posicionY) {
		this.mapa = mapa;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	
	public void moverA(Integer nuevaPosicionX, Integer nuevaPosicionY) {
		while (this.posicionX != nuevaPosicionX && this.posicionY != nuevaPosicionY ) {
			this.moverUnaPosicionHacia(nuevaPosicionX, nuevaPosicionY);
		}
	}
	
	private void moverUnaPosicionHacia(Integer nuevaPosicionX, Integer nuevaPosicionY) {
		if(nuevaPosicionX != this.posicionX) {
			this.moverseEnXHacia(nuevaPosicionX);
		} else {
			this.moverseEnYHacia(nuevaPosicionY);
		}
		if (this.lajas > 0) {
			this.convertirEnCamino();
		}
	}

	private void moverseEnXHacia(Integer nuevaPosicionX) {
		if(nuevaPosicionX > this.posicionX ) {
			this.posicionX ++;
		}
		else {
			this.posicionX --;
		}
	}

	private void moverseEnYHacia(Integer nuevaPosicionY) {
		if(nuevaPosicionY > this.posicionX ) {
			this.posicionX ++;
		}
		else {
			this.posicionX --;
		}
	}

	private void convertirEnCamino() {
		Casillero casilleroActual = mapa.casillero(this.posicionX, this.posicionY);
		if(! casilleroActual.esCamino()) {
			casilleroActual.convertirEnCamino();
			this.lajas --;
		}
	}
	
}
