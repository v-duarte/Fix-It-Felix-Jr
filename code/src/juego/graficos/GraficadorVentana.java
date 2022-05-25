package juego.graficos;

import java.awt.*;

import javax.swing.*;

import juego.niceland.ventanas.*;
import juego.niceland.ventanas.Ventana.tipoVentana;


@SuppressWarnings("unused")
public class GraficadorVentana {
	
	public Image graficar(VentanaComun v){
		Image i;
		i=VentanaComunG.getGraficos().getImagenVentana(v).getImage();
		return i;
	}
	
	public Image graficar(VentanaSemicircular v){
		Image i;
		i=VentanaSemicircularG.getGraficos().getImagenVentana(v).getImage();
		return i;
	}
	
	public Image graficar(VentanaConHojas v){
		Image i;
		i=VentanaConHojasG.getGraficos().getImagenVentana(v).getImage();
		return i;
	}

	public Image graficar (Ventana v){
		if (v.getTipoVentana()==tipoVentana.COMUN)
			return this.graficar((VentanaComun)v);
		else
			if(v.getTipoVentana()==tipoVentana.SEMICIRCULAR)
				return this.graficar((VentanaSemicircular)v);
			else
				return this.graficar((VentanaConHojas)v);
	}

}
