package juego.graficos;

import javax.swing.*;

public class PajaroG {
	private ImageIcon[] pajaro= new ImageIcon[4];
	
	private static PajaroG g;
	
	private PajaroG(){
		pajaro[0]=new CargaImagenes("../../images/pajaro/slice08_08.png").getImg();
		pajaro[1]=new CargaImagenes("../../images/pajaro/slice09_09.png").getImg();
		
		pajaro[2]=new CargaImagenes("../../images/pajaro/slice41_41.png").getImg();
		pajaro[3]=new CargaImagenes("../../images/pajaro/slice61_61.png").getImg();
	}
	
	public static PajaroG getGraficos(){
		if(g==null)
			g=new PajaroG();
		return g;
	}
	
	public ImageIcon[] getImagenPajaro(){
		return pajaro;
	}

}
