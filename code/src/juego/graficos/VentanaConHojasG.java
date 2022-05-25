package juego.graficos;

import javax.swing.ImageIcon;

import juego.niceland.ventanas.*;
import juego.niceland.ventanas.EstadoPanel.estadosVidrios;
import juego.niceland.ventanas.Obstaculo.Obstaculos;

public class VentanaConHojasG {
	private ImageIcon ventanaCHojasCerradas;
	private ImageIcon[] ventanaSinObstaculo=new ImageIcon[3];
	private ImageIcon[] ventanaCMacetero=new ImageIcon[3];
	private ImageIcon[] ventanaCMoldura=new ImageIcon[3];
	
	private static VentanaConHojasG g;
	
	private VentanaConHojasG() {
		ventanaCHojasCerradas=new CargaImagenes("../../images/ventanas_y_panel/slice105_@.png").getImg();
		
		ventanaSinObstaculo[0]=new CargaImagenes("../../images/ventanas_y_panel/slice107_@.png").getImg();
		ventanaSinObstaculo[1]=new CargaImagenes("../../images/ventanas_y_panel/slice101_@.png").getImg();
		ventanaSinObstaculo[2]=new CargaImagenes("../../images/ventanas_y_panel/slice103_@.png").getImg();
		
		ventanaCMacetero[0]=new CargaImagenes("../../images/obstaculos/slice107_@_mac.png").getImg();
		ventanaCMacetero[1]=new CargaImagenes("../../images/obstaculos/slice101_@_mac.png").getImg();
		ventanaCMacetero[2]=new CargaImagenes("../../images/obstaculos/slice103_@_mac.png").getImg();
		
		ventanaCMoldura[0]=new CargaImagenes("../../images/obstaculos/slice107_@_m.png").getImg();
		ventanaCMoldura[1]=new CargaImagenes("../../images/obstaculos/slice101_@_m.png").getImg();
		ventanaCMoldura[2]=new CargaImagenes("../../images/obstaculos/slice103_@_m.png").getImg();
	}
	
	public static VentanaConHojasG getGraficos(){
		if(g==null)
			g= new VentanaConHojasG();
		return g;
	}
	
	public ImageIcon getImagenVentana(VentanaConHojas v){
		ImageIcon i;
		if(v.getHoja().getEstadoHoja()){
			if(v.getObstaculo()==null)
				i=this.getImagenSObstaculos(v);
			else
				i=this.getImagenObstaculos(v);
			}
		else
			i=ventanaCHojasCerradas;
		return i;
	}
	
	private ImageIcon getImagenSObstaculos(VentanaConHojas v){
		if(!v.debeArreglarse())
			return ventanaSinObstaculo[0];
		else{
			if(v.getEstadoGeneral()==estadosVidrios.MEDIOROTO)
				return ventanaSinObstaculo[1];
			else
				return ventanaSinObstaculo[2];
	}	
}
	
	private ImageIcon getImagenObstaculos(VentanaConHojas v){
		if(v.getObstaculo().getTipoObstaculo()==Obstaculos.MACETERO)
			return this.getImagenCMacetero(v);
		else
			return this.getImagenCMoldura(v);
	}
	
	private ImageIcon getImagenCMacetero(VentanaConHojas v){
		if(!v.debeArreglarse())
			return ventanaCMacetero[0];
		else{
			if(v.getEstadoGeneral()==estadosVidrios.MEDIOROTO)
				return ventanaCMacetero[1];
			else
				return ventanaCMacetero[2];
		}
	}
	
	private ImageIcon getImagenCMoldura(VentanaConHojas v){
		if(!v.debeArreglarse())
			return ventanaCMoldura[0];
		else{
			if(v.getEstadoGeneral()==estadosVidrios.MEDIOROTO)
				return ventanaCMoldura[1];
			else
				return ventanaCMoldura[2];
		}
	}

}
