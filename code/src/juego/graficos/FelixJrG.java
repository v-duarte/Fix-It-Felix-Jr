package juego.graficos;

import javax.swing.*;

import juego.felix.FelixJr;
import juego.felix.FelixJr.ProximaAccion;


public class FelixJrG  
{
	//En los array, el lugar 0 es Derecha y 1 es Izquierda.
	
	private ImageIcon[] felixQuieto=new ImageIcon[2];
	private ImageIcon[] felixSeMueve=new ImageIcon[2];
	private ImageIcon[] felixArregla=new ImageIcon[4];
	private ImageIcon[] felixMuere= new ImageIcon[7];
	private ImageIcon[] felixCome= new ImageIcon[8]; 
	
	private static FelixJrG g;
	
	private FelixJrG(){
		felixQuieto[0]= new CargaImagenes("../../images/felix/slice65_65.png").getImg();
		felixQuieto[1]= new CargaImagenes("../../images/felix/slice102_@.png").getImg();
		
		felixSeMueve[0]= new CargaImagenes("../../images/felix/slice67_67.png").getImg();
		felixSeMueve[1]= new CargaImagenes("../../images/felix/slice103_@.png").getImg();
		
		felixArregla[0]= new CargaImagenes("../../images/felix/slice78_78.png").getImg();
		felixArregla[1]= new CargaImagenes("../../images/felix/slice84_84.png").getImg();
		felixArregla[2]= new CargaImagenes("../../images/felix/slice135_@.png").getImg();
		felixArregla[3]= new CargaImagenes("../../images/felix/slice111_@.png").getImg();
		
		felixMuere[0]= new CargaImagenes("../../images/felix/slice292_@.png").getImg();
		felixMuere[1]= new CargaImagenes("../../images/felix/slice293_@.png").getImg();
		felixMuere[2]= new CargaImagenes("../../images/felix/slice294_@.png").getImg();
		felixMuere[3]= new CargaImagenes("../../images/felix/slice295_@.png").getImg();
		felixMuere[4]= new CargaImagenes("../../images/felix/slice296_@.png").getImg();
		felixMuere[5]= new CargaImagenes("../../images/felix/slice297_@.png").getImg();
		felixMuere[6]= new CargaImagenes("../../images/felix/slice298_@.png").getImg();
		
		felixCome[0]= new CargaImagenes("../../images/felix/slice95_95.png").getImg();
		felixCome[1]= new CargaImagenes("../../images/felix/slice66_66.png").getImg();
		felixCome[2]= new CargaImagenes("../../images/felix/slice68_68.png").getImg();
		felixCome[3]= new CargaImagenes("../../images/felix/slice69_69.png").getImg();
		felixCome[4]= new CargaImagenes("../../images/felix/slice120_@.png").getImg();
		felixCome[5]= new CargaImagenes("../../images/felix/slice125_@.png").getImg();
		felixCome[6]= new CargaImagenes("../../images/felix/slice126_@.png").getImg();
		felixCome[7]= new CargaImagenes("../../images/felix/slice127_@.png").getImg();
	}
	
	public static FelixJrG getGraficos(){
		if(g==null)
			g= new FelixJrG();
		return g;
	}
	
	@SuppressWarnings("static-access")
	public ImageIcon getFelixParado(){
		if(FelixJr.getFelix().getProxima()==ProximaAccion.DERECHA)
			return felixQuieto[0];
		else
			return felixQuieto[1];
	}
	
	@SuppressWarnings("static-access")
	public ImageIcon getFelixMoviendose(){
		if(FelixJr.getFelix().getProxima()==ProximaAccion.DERECHA)
			return felixSeMueve[0];
		else
			return felixSeMueve[1];
	}
	
	public ImageIcon[] getAnimacionArreglar(){
		return felixArregla;
	}
	
	public ImageIcon[] getAnimacionFelixCome(){
		return felixCome;
	}
	
	public ImageIcon[] getAnimacionFelixMuere(){
		return felixMuere;
	}
}
