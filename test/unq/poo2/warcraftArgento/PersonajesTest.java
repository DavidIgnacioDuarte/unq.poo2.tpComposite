package unq.poo2.warcraftArgento;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonajesTest {

	
	
	Ejercito ejercito;
	
	Ingeniero alan;
	Ingeniero macri;
	Caballero jack;
	
	Ejercito ejercito2;
	
	
	@BeforeEach
	void setUp() {
		
		ejercito = new Ejercito();
		
		alan = mock(Ingeniero.class);
		macri = mock(Ingeniero.class);
		jack = mock(Caballero.class);
		
		ejercito2 = mock(Ejercito.class);
		
		ejercito.agregarPersonaje(alan);
		ejercito.agregarPersonaje(macri);
		ejercito.agregarPersonaje(jack);
		ejercito.agregarPersonaje(ejercito2);
		
		
	}
	
	@Test
	void testMovimientos() {
		
		ejercito.moverA(10, 8);
		
		verify(alan, times(1)).moverA(10, 8);
		verify(macri, times(1)).moverA(10, 8);
		verify(jack, times(1)).moverA(10, 8);
		verify(ejercito2, times(1)).moverA(10, 8);
		
	}

}
