package unq.poo2.warcraftArgento;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
	
	
	private List<List<Casillero>> casilleros = new ArrayList<List<Casillero>>();
	
	public Mapa(Integer alto, Integer ancho) {
		for (int i = 0; i < ancho; i++) {
			casilleros.add( construirArrayDeCasilleros(alto) );
		}
	}
	
	private List<Casillero> construirArrayDeCasilleros(Integer cantidadCasilleros) {
		List<Casillero> lista =  new ArrayList<Casillero>();
		for (int i = 0; i < cantidadCasilleros; i++) {
			lista.add(new Casillero());
		}
		return lista;
	}
	
	public Casillero casillero(Integer posicionX, Integer posicionY) {
		return casilleros.get(posicionX).get(posicionY);
	}
}
