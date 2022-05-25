package juego.graficos;

import javax.swing.*;

public class SeccionInferiorG {
	String imgname="images/edificio/edificio_150_seccion1.png";
	private ImageIcon img;
	
	private static SeccionInferiorG g;
	
	private SeccionInferiorG(){
		img=new CargaImagenes("../../images/edificio/edificio_150_seccion1.png").getImg();
	}
	
	public static SeccionInferiorG getGraficos(){
		if(g==null)
			g= new SeccionInferiorG();
		return g;
	}
	
	public ImageIcon getImagenSeccion(){
		return img;
	}
}
