package unq.poo2.cultivos;

import java.util.ArrayList;
import java.util.List;

public class CultivoMixto extends PorcionProductivaDeTierra {
	
	List<PorcionProductivaDeTierra> cultivos;
	
	
	public CultivoMixto() {
		cultivos = new ArrayList<PorcionProductivaDeTierra>();
	}
	
	
	public void agregarCultivo(PorcionProductivaDeTierra nuevoCultivo) throws Exception{
		
		if(cultivos.size() == 4) {
			throw new Exception("La porción sólo puede subdividirse en 4.");
		}
		
		cultivos.add(nuevoCultivo);
		
	}
	
	public double gananciaAnual() {
		
		double ganancia = 0;
		for(PorcionProductivaDeTierra cultivo : this.cultivos) {
			ganancia +=  cultivo.gananciaAnual() / 4;
		}
		return ganancia;
		
	}

	public double gananciaAnualTrigo() {
		
		double ganancia = 0;
		for(PorcionProductivaDeTierra cultivo : this.cultivos) {
			if(cultivo instanceof CultivoTrigo) {
				ganancia +=  cultivo.gananciaAnual() / 4;
			}
		}
		return ganancia;
		
	}
	
	public double gananciaAnualSoja() {
		
		double ganancia = 0;
		for(PorcionProductivaDeTierra cultivo : this.cultivos) {
			if(cultivo instanceof CultivoSoja) {
				ganancia +=  cultivo.gananciaAnual() / 4;
			}
		}
		return ganancia;
		
	}
	
}
