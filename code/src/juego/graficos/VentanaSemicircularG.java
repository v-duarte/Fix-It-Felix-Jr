package juego.graficos;

import javax.swing.ImageIcon;

import juego.niceland.ventanas.EstadoPanel.estadosVidrios;
import juego.niceland.ventanas.VentanaSemicircular;
import juego.niceland.ventanas.VentanaSemicircular.tipoSemicircular;

public class VentanaSemicircularG {
	private ImageIcon[] entrada=new ImageIcon[3];
	private ImageIcon[] primerPiso=new ImageIcon[3];
	private static VentanaSemicircularG g;

	private VentanaSemicircularG() {
		entrada[0]=new CargaImagenes("../../images/semicirculares/slice600_@.png").getImg();
		entrada[1]=new CargaImagenes("../../images/semicirculares/slice594_@.png").getImg();
		entrada[2]=new CargaImagenes("../../images/semicirculares/slice591_@.png").getImg();
		
		primerPiso[0]=new CargaImagenes("../../images/semicirculares/slice602_@.png").getImg();
		primerPiso[1]=new CargaImagenes("../../images/semicirculares/slice603_@.png").getImg();
		primerPiso[2]=new CargaImagenes("../../images/semicirculares/slice604_@.png").getImg();
	}
	
	public static VentanaSemicircularG getGraficos(){
		if(g==null)
			g=new VentanaSemicircularG();
		return g;
	}
	
	public ImageIcon getImagenVentana(VentanaSemicircular v) {
		ImageIcon i;
		if(v.getClaseSemicircular()==tipoSemicircular.ENTRADA){
			i=this.getImagenEntrada(v);
		}
		else
			i=this.getImagenPrimerPiso(v);
		return i;
	}
	
	private ImageIcon getImagenEntrada(VentanaSemicircular v){
		if(!v.debeArreglarse())
			return entrada[0];
		else{
			if(v.getEstadoGeneral()==estadosVidrios.MEDIOROTO)
				return entrada[1];
			else
				return entrada[2];
		}
	}
	
	private ImageIcon getImagenPrimerPiso(VentanaSemicircular v){
		if(!v.debeArreglarse())
			return primerPiso[0];
		else{
		if(v.getEstadoGeneral()==estadosVidrios.MEDIOROTO)
			return primerPiso[1];
		else
			return primerPiso[2];
		}
	}
	
}
