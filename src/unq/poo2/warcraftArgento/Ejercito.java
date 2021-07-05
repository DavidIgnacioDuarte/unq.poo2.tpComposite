package unq.poo2.warcraftArgento;

import java.util.ArrayList;
import java.util.List;

public class Ejercito extends TipoDePersonaje {
	
	private List<TipoDePersonaje> personajes;
	
	public Ejercito() {
		this.personajes = new ArrayList<TipoDePersonaje>();
	}
	
	
	public void moverA(Integer nuevaPosicionX, Integer nuevaPosicionY) {
		for(TipoDePersonaje personaje : personajes) {
			personaje.moverA(nuevaPosicionX, nuevaPosicionY);
		}
	}
	
	public void agregarPersonaje(TipoDePersonaje nuevoPersonaje) {
		this.personajes.add(nuevoPersonaje);
	}
	public void borrarPersonaje(TipoDePersonaje personajeABorrar) {
		this.personajes.remove(personajeABorrar);
	}
	
	public TipoDePersonaje obtenerPersonaje(Integer posicion) {
		return this.personajes.get(posicion);
	}
	
}
