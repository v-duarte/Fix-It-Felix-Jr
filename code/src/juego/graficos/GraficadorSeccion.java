package juego.graficos;

import java.awt.Image;


import juego.niceland.secciones.Seccion;
import juego.niceland.secciones.Seccion.TipoSeccion;
import juego.niceland.secciones.SeccionInferior;
import juego.niceland.secciones.SeccionMedia;
import juego.niceland.secciones.SeccionSuperior;




public class GraficadorSeccion {
	
	public Image graficar(SeccionInferior s){
		return SeccionInferiorG.getGraficos().getImagenSeccion().getImage();
	}
	
	public Image graficar(SeccionMedia s){
		return SeccionMediaG.getGraficos().getImagenSeccion().getImage();
	}
	
	public Image graficar(SeccionSuperior s){
		return SeccionSuperiorG.getGraficos().getImagenSeccion().getImage();
	}
	
	public Image graficar(Seccion s){
		if(s.getTipoSeccion()==TipoSeccion.INFERIOR)
			return this.graficar((SeccionInferior) s);
		else
			if(s.getTipoSeccion()==TipoSeccion.MEDIA)
				return this.graficar((SeccionMedia) s);
			else
				return this.graficar((SeccionSuperior) s);
	}
}
