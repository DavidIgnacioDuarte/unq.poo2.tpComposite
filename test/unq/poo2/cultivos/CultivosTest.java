package unq.poo2.cultivos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CultivosTest {

	
	CultivoTrigo cultivoTrigo;
	CultivoSoja cultivoSoja;
	CultivoMixto cultivoMixto1;
	CultivoMixto cultivoMixto2;
	
	
	@BeforeEach
	void setUp() {
		
		cultivoTrigo = new CultivoTrigo();
		cultivoSoja = new CultivoSoja();
		cultivoMixto1 = new CultivoMixto();
		cultivoMixto2 = new CultivoMixto();
		
	}
	
	
	@Test
	void testGananciaAnualComposite() throws Exception{
		
		assertEquals(300, cultivoTrigo.gananciaAnual());
		assertEquals(500, cultivoSoja.gananciaAnual());
		
		cultivoMixto1.agregarCultivo(cultivoTrigo);
		cultivoMixto1.agregarCultivo(cultivoTrigo);
		cultivoMixto1.agregarCultivo(cultivoTrigo);
		cultivoMixto1.agregarCultivo(cultivoSoja);
		
		cultivoMixto2.agregarCultivo(cultivoSoja);
		cultivoMixto2.agregarCultivo(cultivoSoja);
		cultivoMixto2.agregarCultivo(cultivoSoja);
		cultivoMixto2.agregarCultivo(cultivoTrigo);
		
		double gananciaTrigoCultivoMixto1 = cultivoMixto1.gananciaAnualTrigo();
		double gananciaSojaCultivoMixto1 = cultivoMixto1.gananciaAnualSoja();
		double gananciaSojaCultivoMixto2 = cultivoMixto2.gananciaAnualSoja();
		double gananciaTrigoCultivoMixto2 = cultivoMixto2.gananciaAnualTrigo();
		
		assertEquals(225, gananciaTrigoCultivoMixto1); //3 trigos -> 75 + 75 + 75
		assertEquals(125, gananciaSojaCultivoMixto1); //1 soja -> 125
		assertEquals(375, gananciaSojaCultivoMixto2); //3 sojas -> 125 + 125 +125
		assertEquals(75, gananciaTrigoCultivoMixto2); //1 trigo -> 75
		
		
		double gananciaTotalCultivoMixto1 = cultivoMixto1.gananciaAnual();
		double gananciaTotalCultivoMixto2 = cultivoMixto2.gananciaAnual();
		
		assertEquals(350, gananciaTotalCultivoMixto1);
		assertEquals(450, gananciaTotalCultivoMixto2);
		
	}

}
